<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilos/stylefactura.css">
    <title>Document</title>
</head>
<body>
    <p>User ID: ${sessionScope.userId}</p>
    <form action="factura" method="post">
        <h3>Poner tus facturas</h3>

        <label for="fecha_emision">Fecha Emision:</label>
        <input type="date" name="fecha_emision" id="fecha_emision" required>

        <label for="fecha_vencimiento">Fecha Vencimiento:</label>
        <input type="date" name="fecha_vencimiento" id="fecha_vencimiento" required>

        <label>Factura tipo:</label>
        <div class="radio-group">
            <label><input type="radio" name="factura_tipo_id" value="1" required>CREDITO</label>
            <label><input type="radio" name="factura_tipo_id" value="2" required>DEBITO</label>
        </div>

        <label for="monedas">Tipo de monedas:</label>
        <select name="moneda_id" id="monedas" required>
            <option value="1">Krona</option>
            <option value="2">Yuan Renminbi</option>
            <option value="3">Peso</option>
            <option value="4">Rupee</option>
            <option value="5">Ruble</option>
            <option value="6">Euro</option>
            <option value="7">Rupiah</option>
        </select>

        <label for="productos">Tipo de productos:</label>
        <select name="producto_id" id="productos" required>
            <option value="1">Oregano - Fresh</option>
            <option value="2">Sponge Cake Mix - Vanilla</option>
            <option value="3">Cake - Cheese Cake 9 Inch</option>
            <option value="4">Pepper - Chilli Seeds Mild</option>
        </select>

        <label for="cantidad">Cantidad:</label>
        <input type="number" name="cantidad" id="cantidad" min="1" required>

        <button type="submit">Enviar</button>
    </form>
</body>
</html>