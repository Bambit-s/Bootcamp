<%@ include file="header.jsp" %>
<h2>Formulario de Registro</h2>
<form th:action="@{/register}" th:object="${user}" method="post">

    <label for="">Nombre: </label>
    <input type="text" th:field="*{nombre}"/><br>
    <label for="">Apellido: </label>
    <input type="text" th:field="*{apellido}" /><br>
    <label for="">Numero Cedula: </label>
    <input type="text" th:field="*{nroCedula}" /><br>
    <label for="">Correo electronico: </label>
    <input type="email" th:field="*{correo}" /><br>
    <label for="">Contrasena: </label>
    <input type="password" th:field="*{contrasena}" /><br>
    <label for="">Telefono: </label>
    <input type="text" th:field="*{telefono}" /><br>

    <label for="">Rol:</label>
    <select th:field="*{idRol}">
        <option>TH</option>
        <option>OPERACIONES</option>
        <option>DIRECTORIO</option>
        <option>LIDER</option>
        <option>FUNCIONARIO_FABRICA</option>
        <option>FUNCIONARIO_TERCERIZADO</option>
        <option>GTH</option>
    </select><br>

    <label for="">Equipo:</label>
    <select th:field="*{idEquipo}">
        <option>Roshka Studios</option>
        <option>Directorio</option>
        <option>Mantenimiento - DS</option>
        <option>SUDAMERIS FABRICA</option>
    </select><br>

    <label for="">Cargo:</label>
    <select th:field="*{idCargo}">
        <option>Analista de QA</option>
        <option>Analista de sistemas</option>
        <option>Analista de Soporte de aplicaciones</option>
    </select><br>

    <label for="">Fecha de Nacimiento:</label>
    <input type="date" th:field="*{fechaNacimiento}" /><br>

    <button type="submit">Registrar</button>
</form>
<%@ include file="footer.jsp" %>