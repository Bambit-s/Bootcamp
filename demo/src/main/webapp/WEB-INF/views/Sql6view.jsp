<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %> <!-- for loop for to undestand c:forEach  -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>SQL 6 Results</title>
</head>
<body>
    <h1 style="color:red;">Productos menos vendidos</h1>
    <ul>
        <c:forEach var="c" items="${clientes}">
            <li>
                Proveedor Id: ${c.proveedorId} |
                Nombre Proveedor: ${c.nombreProveedor} |
                Cantidad Veces: ${c.cantidadVeces}
            </li>
        </c:forEach>
    </ul>
</body>
</html>