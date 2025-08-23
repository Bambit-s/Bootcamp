<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %> <!-- for loop for to undestand c:forEach  -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>SQL 5 Results</title>
</head>
<body>
    <h1 style="color:red;">Productos mas vendidos</h1>
    <ul>
        <c:forEach var="c" items="${clientes}">
            <li>
                Product Id: ${c.productoId} |
                All Products: ${c.allProducts} |
            </li>
        </c:forEach>
    </ul>
</body>
</html>