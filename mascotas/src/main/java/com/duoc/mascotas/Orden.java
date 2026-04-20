package com.duoc.mascotas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

/**
 * Clase que representa la entidad de Orden para el microservicio de Mascotas.
 */
@Entity
@Table(name = "PEDIDOS_MASCOTAS") // Nombre de la tabla en Oracle
public class Orden {

    @Id
    @Column(name = "ID_PEDIDO") // <--- ESTE ES EL CAMBIO. Antes decía ID_ORDEN
    private int idOrden;

    @Column(name = "PRODUCTO")
    private String producto;

    @Column(name = "PRECIO")
    private double precio;

    @Column(name = "ESTADO")
    private String estado;

    // IMPORTANTE: Constructor vacío obligatorio para JPA
    public Orden() {
    }

    // Tu constructor original
    public Orden(int idOrden, String producto, double precio, String estado) {
        this.idOrden = idOrden;
        this.producto = producto;
        this.precio = precio;
        this.estado = estado;
    }

    // Getters
    public int getIdOrden() { return idOrden; }
    public String getProducto() { return producto; }
    public double getPrecio() { return precio; }
    public String getEstado() { return estado; }

    // Setters (Necesarios para que Spring llene los datos desde Postman)
    public void setIdOrden(int idOrden) { this.idOrden = idOrden; }
    public void setProducto(String producto) { this.producto = producto; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setEstado(String estado) { this.estado = estado; }
}