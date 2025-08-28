package com.example.demo.dao;

import org.postgresql.util.PGInterval;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.RegistraitionDAO.PasswordUtil;
import com.example.demo.model.UserModelIndex;

import java.sql.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IndexDAO {

    private final String url = "jdbc:postgresql://localhost:5432/crud_de_usuario";
    private final String user = "postgres";
    private final String password = "12345678";

    public List<UserModelIndex> getAllUsers(Integer rol, Integer equipo, Integer cargo) {
        List<UserModelIndex> users = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM usuarios WHERE 1=1");

        if (rol != null && rol != 0) {
            sql.append(" AND id_rol = ?");
        }
        if (equipo != null && equipo != 0) {
            sql.append(" AND id_equipo = ?");
        }
        if (cargo != null && cargo != 0) {
            sql.append(" AND id_cargo = ?");
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            int index = 1;
            if (rol != null && rol != 0)
                stmt.setObject(index++, rol, java.sql.Types.INTEGER);
            if (equipo != null && equipo != 0)
                stmt.setObject(index++, equipo, java.sql.Types.INTEGER);
            if (cargo != null && cargo != 0)
                stmt.setObject(index++, cargo, java.sql.Types.INTEGER);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UserModelIndex usermodel = new UserModelIndex();

                usermodel.setId_usuario(rs.getInt("id_usuario"));
                usermodel.setNombre(rs.getString("nombre"));
                usermodel.setApellido(rs.getString("apellido"));
                usermodel.setNro_cedula(rs.getInt("nro_cedula"));
                usermodel.setCorreo(rs.getString("correo"));
                usermodel.setId_rol(rs.getInt("id_rol"));

                Date fechaIngreso = rs.getDate("fecha_ingreso");
                if (fechaIngreso != null) {
                    usermodel.setFecha_ingreso(fechaIngreso.toLocalDate());
                }

                PGInterval interval = (PGInterval) rs.getObject("antiguedad");
                Period antiguedad = Period.of(interval.getYears(), interval.getMonths(), (int) interval.getDays());
                usermodel.setAntiguedad(antiguedad);

                usermodel.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                usermodel.setEstado(rs.getBoolean("estado"));
                usermodel.setContrasena(rs.getString("contrasena"));
                usermodel.setTelefono(rs.getString("telefono"));
                usermodel.setId_equipo(rs.getInt("id_equipo"));
                usermodel.setId_cargo(rs.getInt("id_cargo"));

                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                if (fechaNacimiento != null) {
                    usermodel.setFecha_nacimiento(fechaNacimiento.toLocalDate());
                }

                usermodel.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                usermodel.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                users.add(usermodel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public UserModelIndex getOneUser(int id) {
        UserModelIndex usermodel = null;
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usermodel = new UserModelIndex();

                usermodel.setId_usuario(rs.getInt("id_usuario"));
                usermodel.setNombre(rs.getString("nombre"));
                usermodel.setApellido(rs.getString("apellido"));
                usermodel.setNro_cedula(rs.getInt("nro_cedula"));
                usermodel.setCorreo(rs.getString("correo"));
                usermodel.setId_rol(rs.getInt("id_rol"));

                Date fechaIngreso = rs.getDate("fecha_ingreso");
                if (fechaIngreso != null) {
                    usermodel.setFecha_ingreso(fechaIngreso.toLocalDate());
                }

                PGInterval interval = (PGInterval) rs.getObject("antiguedad");
                if (interval != null) {
                    Period antiguedad = Period.of(interval.getYears(), interval.getMonths(), (int) interval.getDays());
                    usermodel.setAntiguedad(antiguedad);
                }

                usermodel.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                usermodel.setEstado(rs.getBoolean("estado"));
                usermodel.setContrasena(rs.getString("contrasena"));
                usermodel.setTelefono(rs.getString("telefono"));
                usermodel.setId_equipo(rs.getInt("id_equipo"));
                usermodel.setId_cargo(rs.getInt("id_cargo"));

                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                if (fechaNacimiento != null) {
                    usermodel.setFecha_nacimiento(fechaNacimiento.toLocalDate());
                }

                usermodel.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                usermodel.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usermodel;
    }

    public UserModelIndex deleteOneUser(int id) {

        UserModelIndex userToDelete = getOneUser(id);

        String sql1 = "DELETE FROM usuarios WHERE id_usuario = ?";

        if (userToDelete == null) {
            return null;
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql1)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return userToDelete;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public UserModelIndex createOneUser(UserModelIndex user) {
        String hashed = PasswordUtil.hashPassword(user.getContrasena());

        int newId = getMaxId() + 1;
        user.setId_usuario(newId);
        user.setContrasena(hashed);

        String sqlInsert = "INSERT INTO usuarios ("
                + "id_usuario, nombre, apellido, nro_cedula, correo, id_rol, fecha_ingreso, "
                + "dias_vacaciones, estado, contrasena, telefono, id_equipo, "
                + "id_cargo, fecha_nacimiento, dias_vacaciones_restante, requiere_cambio_contrasena"
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String sqlUpdateAntiguedad = "UPDATE usuarios SET antiguedad = '0 years 0 months 1 days'::interval WHERE id_usuario = ?";

        try (Connection conn = DriverManager.getConnection(url, this.user, password)) {

            // INSERT
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                pstmt.setInt(1, user.getId_usuario());
                pstmt.setString(2, user.getNombre());
                pstmt.setString(3, user.getApellido());
                pstmt.setInt(4, user.getNro_cedula());
                pstmt.setString(5, user.getCorreo());
                pstmt.setInt(6, user.getId_rol());
                pstmt.setDate(7, java.sql.Date.valueOf(user.getFecha_ingreso()));
                pstmt.setInt(8, user.getDias_vacaciones());
                pstmt.setBoolean(9, user.isEstado());
                pstmt.setString(10, user.getContrasena());
                pstmt.setString(11, user.getTelefono());
                pstmt.setInt(12, user.getId_equipo());
                pstmt.setInt(13, user.getId_cargo());
                pstmt.setDate(14, java.sql.Date.valueOf(user.getFecha_nacimiento()));
                pstmt.setInt(15, user.getDias_vacaciones_restante());
                pstmt.setBoolean(16, user.isRequiere_cambio_contrasena());

                pstmt.executeUpdate();
            }

            try (PreparedStatement pstmt2 = conn.prepareStatement(sqlUpdateAntiguedad)) {
                pstmt2.setObject(1, user.getId_usuario());
                pstmt2.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public UserModelIndex updateOneUser(UserModelIndex user) {
        String sql = "UPDATE usuarios SET "
                + "nombre = ?, "
                + "apellido = ?, "
                + "nro_cedula = ?, "
                + "correo = ?, "
                + "id_rol = ?, "
                + "fecha_ingreso = ?, "
                + "antiguedad = ?, "
                + "dias_vacaciones = ?, "
                + "estado = ?, "
                + "contrasena = ?, "
                + "telefono = ?, "
                + "id_equipo = ?, "
                + "id_cargo = ?, "
                + "fecha_nacimiento = ?, "
                + "dias_vacaciones_restante = ?, "
                + "requiere_cambio_contrasena = ? "
                + "WHERE id_usuario = ?";

        try (Connection conn = DriverManager.getConnection(url, this.user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getNombre());
            pstmt.setString(2, user.getApellido());
            pstmt.setInt(3, user.getNro_cedula());
            pstmt.setString(4, user.getCorreo());
            pstmt.setInt(5, user.getId_rol());
            pstmt.setDate(6, java.sql.Date.valueOf(user.getFecha_ingreso()));

            // PGInterval для antiguedad
            Period p = user.getAntiguedad() != null ? user.getAntiguedad() : Period.of(0, 0, 0);
            PGInterval interval = new PGInterval(p.getYears(), p.getMonths(), p.getDays(), 0, 0, 0);
            pstmt.setObject(7, interval);

            pstmt.setInt(8, user.getDias_vacaciones());
            pstmt.setBoolean(9, user.isEstado());
            pstmt.setString(10, user.getContrasena());
            pstmt.setString(11, user.getTelefono());
            pstmt.setInt(12, user.getId_equipo());
            pstmt.setInt(13, user.getId_cargo());
            pstmt.setDate(14, java.sql.Date.valueOf(user.getFecha_nacimiento()));
            pstmt.setInt(15, user.getDias_vacaciones_restante());
            pstmt.setBoolean(16, user.isRequiere_cambio_contrasena());

            pstmt.setInt(17, user.getId_usuario()); // WHERE id_usuario = ?

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Updated rows: " + rowsUpdated);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private int getMaxId() {
        int maxId = 0;
        String sql = "SELECT MAX(id_usuario) AS max_id FROM usuarios";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                maxId = rs.getInt("max_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxId;
    }

}