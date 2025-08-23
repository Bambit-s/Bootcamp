<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %> <!-- for loop for to undestand c:forEach  -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>SQL 9 Results</title>
</head>
<body>
    <h1 style="color:red;">Mostrar el iva 10% de los montos totales de facturas (suponer que todos los productos tienen IVA 10%)</h1>
    <ul>
        <c:forEach var="c" items="${clientes}">
            <li>
                Factura Id: ${c.facturaId} |
                Con Iva Diez: ${c.conIvaDiez}
            </li>
        </c:forEach>
    </ul>
</body>
</html>