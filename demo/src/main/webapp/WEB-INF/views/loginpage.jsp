<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilos/stylelogin.css">
    <title>Login page</title>
</head>
<body>
    <div>
        <form action="/loginpage" method="post">
            <label>Nombre:</label>
            <input type="text" name="nombre" />
            <br>
            <label>Apellido:</label>
            <input type="text" name="apellido" />
            <br>
            <label>Nro_cedula:</label>
            <input type="text" name="nro_cedula" />
            <br>
            <label>Telefono:</label>
            <input type="text" name="telefono" />
            <br>
            <button type="submit">Enviar</button>
        </form>
    </div>
</body>
</html>