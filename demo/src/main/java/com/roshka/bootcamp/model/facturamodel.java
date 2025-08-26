package com.roshka.bootcamp.model;
import java.util.Date;

public class facturamodel {
    private int facturaId;
    private int cliente_id;
    private Date fecha_emision;
    private Date fecha_vencimiento;
    private int factura_tipo;
    private int moneda;
    private int producto_id;
    private int cantidad;

    public facturamodel(int facturaId, int cliente_id, Date fecha_emision, Date fecha_vencimiento, int factura_tipo,int moneda, int producto_id, int cantidad) {
        
        this.facturaId = facturaId;
        this.cliente_id = cliente_id;
        this.fecha_emision = fecha_emision;
        this.fecha_vencimiento = fecha_vencimiento;
        this.factura_tipo = factura_tipo;
        this.moneda = moneda;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
    }
    
    public int getFacturaId() {return facturaId;}
    public int getUserId() {return cliente_id;}
    public Date getFechaEmision() {return fecha_emision;}
    public Date getFechaVencimiento() {return fecha_vencimiento;}
    public int getFacturaTipo() {return factura_tipo;}
    public int getMoneda() {return moneda;}
    public int getproducto_id() {return producto_id;}
    public int getCantidad() {return cantidad;}
}
