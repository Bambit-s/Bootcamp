<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido</title>
</head>
<body>
    <h2>Bienvenido, <%= session.getAttribute("username") %>!</h2>
    <a href="logoutjsp.jsp">Cerrar sesión</a>
</body>
</html>
