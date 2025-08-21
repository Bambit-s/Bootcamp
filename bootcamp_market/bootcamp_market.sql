--1. Top clientes con más facturas--
SELECT c.id, c.nombre, c.apellido, COUNT(f.id) as cantidad_facturas
FROM factura f
    JOIN cliente c ON f.cliente_id = c.id
GROUP BY
    c.id,
    c.nombre,
    c.apellido
ORDER BY cantidad_facturas DESC
LIMIT 10;

--2.	Top clientes que más gastaron --
SELECT c.cliente_id, k.nombre, k.apellido, f.factura_id, SUM(f.cantidad) as suma_cantidad
FROM
    factura_detalle f
    JOIN factura c ON c.id = f.factura_id
    JOIN cliente k ON c.cliente_id = k.id
GROUP BY
    c.cliente_id,
    k.nombre,
    k.apellido,
    f.factura_id
ORDER BY suma_cantidad DESC
LIMIT 10;

--3.	Top monedas más utilizadas--
SELECT
    f.moneda_id,
    m.nombre as moneda_nombre,
    COUNT(*) as cantidad_facturas
FROM factura f
    LEFT JOIN moneda m ON f.moneda_id = m.id
GROUP BY
    f.moneda_id,
    m.nombre
ORDER BY cantidad_facturas DESC;

--4.	Top proveedor de productos--
SELECT producto.proveedor_id, COUNT(*) as cantidad_veces
FROM factura_detalle
    INNER JOIN producto ON factura_detalle.producto_id = producto.id
GROUP BY
    producto.proveedor_id
ORDER BY cantidad_veces DESC;

--5.	Productos más vendidos--
WITH
    counts AS (
        SELECT factura_detalle.producto_id, COUNT(*) as all_products
        FROM factura_detalle
            INNER JOIN factura ON factura_detalle.factura_id = factura.id
        GROUP BY
            factura_detalle.producto_id
    )
SELECT producto_id, all_products
FROM counts
WHERE
    all_products = (
        SELECT MAX(all_products)
        FROM counts
    );

--6.	Productos menos vendidos--
WITH
    counts AS (
        SELECT factura_detalle.producto_id, COUNT(*) as all_products
        FROM factura_detalle
            INNER JOIN factura ON factura_detalle.factura_id = factura.id
        GROUP BY
            factura_detalle.producto_id
    )
SELECT producto_id, all_products
FROM counts
WHERE
    all_products = (
        SELECT min(all_products)
        FROM counts
    );

--7.	Consulta que muestre fecha de emisión de factura, nombre y apellido del cliente, nombres de productos de esa factura, cantidades compradas, nombre de tipo de factura de una factura específica--
SELECT factura.fecha_emision, cliente.nombre, cliente.apellido, producto.nombre as product_name, factura_detalle.cantidad, factura_tipo.nombre as factura_nombre
FROM
    factura
    Inner JOIN factura_detalle ON factura_detalle.factura_id = factura.id
    Inner JOIN cliente ON factura.cliente_id = cliente.id
    Inner JOIN factura_tipo ON factura.factura_tipo_id = factura_tipo.id
    Inner JOIN producto ON factura_detalle.producto_id = producto.id

--8.	Montos de facturas ordenadas según totales--
SELECT factura_detalle.factura_id, ROUND(
        SUM(
            producto.precio * factura_detalle.cantidad
        )
    ) as totalfactura
From
    factura_detalle
    INNER JOIN factura ON factura.id = factura_detalle.factura_id
    INNER JOIN producto ON producto.id = factura_detalle.producto_id
GROUP BY
    factura_detalle.factura_id
ORDER BY totalfactura;

--9.	Mostrar el iva 10% de los montos totales de facturas (suponer que todos los productos tienen IVA 10%)--
SELECT fd.factura_id, SUM(fd.cantidad * p.precio * 1.10) as coniva10
FROM
    factura_detalle fd
    INNER JOIN factura f on f.id = fd.factura_id
    Inner join producto p on p.id = fd.producto_id
GROUP BY
    fd.factura_id
ORDER BY fd.factura_id;