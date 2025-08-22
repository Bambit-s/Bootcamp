<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %> <!-- for loop for to undestand c:forEach  -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Top Clientes</title>
</head>
<body>
    <h1 style="color:red;">Top 10 clientes con más facturas</h1>
    <ul>
        <c:forEach var="c" items="${clientes}">
            <li>
                Id: ${c.id} |
                Nombre: ${c.nombre} |
                Apellido: ${c.apellido} |
                Cantidad Facturas: ${c.cantidadFacturas}
            </li>
        </c:forEach>
    </ul>
</body>
</html>