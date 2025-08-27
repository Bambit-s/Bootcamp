<%@ include file="header.jsp" %>
<h2>Formulario de Registro</h2>
<form action="/registration" method="post">
    <input type="hidden" name="id">

    <label for="">Nombre: </label>
    <input type="text" name="nombre"/><br>

    <label for="">Apellido: </label>
    <input type="text" name="apellido" /><br>

    <label for="">Numero Cedula: </label>
    <input type="text" name="numeroSedula" /><br>

    <label for="">Correo electronico: </label>
    <input type="email" name="correoElectronico" /><br>

    <label for="">Rol:</label>
    <select name ="idRol">
        <option value="1">TH</option>
        <option value="2">OPERACIONES</option>
        <option value="3">DIRECTORIO</option>
        <option value="4">LIDER</option>
        <option value="5">FUNCIONARIO_FABRICA</option>
        <option value="6">FUNCIONARIO_TERCERIZADO</option>
        <option value="7">GTH</option>
    </select><br>

    <input type="hidden" name="fecha_ingreso">
    
    <input type="hidden" name="antiguedad">

    <input type="hidden" name="dias_vacaciones">

    <input type="hidden" name="estado">
    
    <label for="">Contrasena: </label>
    <input type="password" name="contrasena" /><br>

    <label for="">Telefono: </label>
    <input type="text" name="telefono" /><br>

    <label for="">Equipo:</label>
    <select name="idEquipo">
        <option value="1">Roshka Studios</option>
        <option value="2">Directorio</option>
        <option value="3">Mantenimiento - DS</option>
        <option value="4">SUDAMERIS FABRICA</option>
    </select><br>
    
    <label for="">Cargo:</label>
    <select name="idCargo">
        <option value="1">Analista de QA</option>
        <option value="2">Analista de sistemas</option>
        <option value="3">Analista de Soporte de aplicaciones</option>
    </select><br>
    
    <label for="">Fecha de Nacimiento:</label>
    <input type="date" name="fechaNacimiento" /><br>
    
    <input type="hidden" name="dias_vacaciones_restante">

    <button type="submit">Registrar</button>
</form>
<%@ include file="footer.jsp" %>