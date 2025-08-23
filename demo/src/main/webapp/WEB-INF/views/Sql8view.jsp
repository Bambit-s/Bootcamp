<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %> <!-- for loop for to undestand c:forEach  -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>SQL 8 Results</title>
</head>
<body>
    <h1 style="color:red;">Montos de facturas ordenadas según totales</h1>
    <ul>
        <c:forEach var="c" items="${clientes}">
            <li>
                Factura Id: ${c.facturaId} |
                Total Factura: ${c.totalFactura}
            </li>
        </c:forEach>
    </ul>
</body>
</html>