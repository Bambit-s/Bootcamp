<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cerrar Sesión</title>
</head>
<body>
    <%
        session.invalidate();
    %>
    <h2>Sesión cerrada correctamente</h2>
    <a href="loginjsp.jsp">Volver al inicio de sesión</a>
</body>
</html>
