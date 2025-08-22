<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %> <!-- for loop for to undestand c:forEach  -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>SQL 3 Results</title>
</head>
<body>
    <h1 style="color:red;">Top monedas mas utilizadas</h1>
    <ul>
        <c:forEach var="c" items="${clientes}">
            <li>
                Moneda Id: ${c.monedaId} |
                Moneda nombre: ${c.monedaNombre} |
                Cantidad facturas: ${c.cantidadFacturas}
            </li>
        </c:forEach>
    </ul>
</body>
</html>