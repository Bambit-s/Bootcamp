<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %> <!-- for loop for to undestand c:forEach  -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>SQL 7 Results</title>
</head>
<body>
    <h1 style="color:red;">Consulta que muestre fecha de emisión de factura, nombre y apellido del cliente, nombres de productos de esa factura, cantidades compradas, nombre de tipo de factura de una factura específica</h1>
    <ul>
        <c:forEach var="c" items="${clientes}">
            <li>
                Fecha Emision: ${c.fechaEmision} |
                Nombre: ${c.nombre} |
                Apellido: ${c.apellido} |
                Product Name: ${c.productName} |
                Cantidad: ${c.cantidad} |
                Factura Nombre: ${c.facturaNombre} |
            </li>
        </c:forEach>
    </ul>
</body>
</html>