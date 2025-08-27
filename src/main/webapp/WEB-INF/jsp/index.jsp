<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>Page Index</p>
<h2>Usuarios</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id_usuario}</td>
            <td>${user.nombre}</td>
            <td>${user.apellido}</td>
            <td>
                <form action="/usuario/delete/${user.id_usuario}" method="post">
                    <input type="hidden" name="_method" value="delete"/>
                    <button type="submit">Del ${user.id_usuario}</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="footer.jsp" %>