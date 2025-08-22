<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %> <!-- for loop for to undestand c:forEach  -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>SQL 2 Results</title>
</head>
<body>
    <h1 style="color:red;">Top clientes que mas gastaron</h1>
    <ul>
        <c:forEach var="c" items="${clientes}">
            <li>
                Client Id: ${c.clienteId} |
                Nombre: ${c.nombre} |
                Apellido: ${c.apellido} |
                Factura Id: ${c.facturaId}
                Suma Cantidad: ${c.sumaCantidad}
            </li>
        </c:forEach>
    </ul>
</body>
</html>