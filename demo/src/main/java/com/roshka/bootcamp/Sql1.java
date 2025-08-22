package com.roshka.bootcamp;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;

@WebServlet("/sql1")
public class Sql1 extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();

        // mostramos los parametros del contexto
        Enumeration<String> attributeNames = context.getInitParameterNames();

        while (attributeNames.hasMoreElements()) {
            String eachName = attributeNames.nextElement();
            System.out.println("Context Param name: " + eachName);
        }

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(context.getInitParameter("dbUrl"), context.getInitParameter("dbUser"),
                            context.getInitParameter("dbPassword"));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            Statement stmt = connection.createStatement();
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            ResultSet rs = stmt
                    .executeQuery("SELECT c.id, c.nombre, c.apellido, COUNT(f.id) as cantidad_facturas\r\n" + //
                            "FROM factura f\r\n" + //
                            "    JOIN cliente c ON f.cliente_id = c.id\r\n" + //
                            "GROUP BY\r\n" + //
                            "    c.id,\r\n" + //
                            "    c.nombre,\r\n" + //
                            "    c.apellido\r\n" + //
                            "ORDER BY cantidad_facturas DESC\r\n" + //
                            "LIMIT 10;");
            out.println("<html>");
            out.println("<body>");
            out.println("<h1 style=\"color:red;\">Esta es una url distinta</h1>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cantidad_facturas = rs.getInt("cantidad_facturas");
                out.println(
                        "Id: " + id +
                                " | " + "Nombre: " + nombre +
                                " | " + "Apellido: " + apellido +
                                " | " + " Cantidad facturas: " + cantidad_facturas);
            }
            out.println("</body>");
            out.println("</html>");
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }

    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
