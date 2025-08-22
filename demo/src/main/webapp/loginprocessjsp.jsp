<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Procesando Inicio de Sesión</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verifica las credenciales (aquí se haría la lógica real de autenticación)
        if ("username".equals(username) && "password".equals(password)) {
            session.setAttribute("username", username);
            response.sendRedirect("welcomejsp.jsp");
        } else {
    %>
            <h2>Error de inicio de sesión</h2>
            <p>Usuario o contraseña incorrectos. Inténtelo de nuevo.</p>
            <a href="login.jsp">Volver al inicio de sesión</a>
    <%
        }
    %>
</body>
</html>
