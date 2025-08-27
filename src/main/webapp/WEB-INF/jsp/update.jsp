<%@ include file="header.jsp" %>
<form action="/update/${user.id_usuario}" method="post">
    <input type="hidden" name="_method" value="put"/>
    <p>${user.id_usuario}</p>
    <p>${user.nombre}</p>
    <label for="">Combiar nombre</label>
    <input type="text" name="nombre"><br>
    <p>${user.apellido}</p>
    <label for="">Combiar apellido</label>
    <input type="text" name="apellido"><br>
    <button type="submit">Actualizar datos</button>
</form>
<%@ include file="footer.jsp" %>