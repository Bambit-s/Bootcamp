<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consulta</title>
</head>
<body>
    <%
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/bootcamp_market", "postgres", "postgres");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select a.nombre, apellido, count(b.cliente_id) Cantidad_factura from cliente a " +
                                "inner join factura b " +
                                "on a.id=b.cliente_id " +
                                "group by a.nombre, a.apellido " +
                                "order by Cantidad_factura desc;");
    %>
            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Cantidad de Facturas</th>
                </tr>
    <%
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cantidad = rs.getInt("Cantidad_factura");
    %>
                <tr>
                    <td><%= nombre %></td>
                    <td><%= apellido %></td>
                    <td><%= cantidad %></td>
                </tr>
    <%
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    %>
    </table>
</body>
</html>
