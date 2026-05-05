package com.duoc.mascotas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Clase que representa la entidad de Orden para el microservicio de Mascotas.
 */
@Entity
@Table(name = "PEDIDOS_MASCOTAS") // Nombre de la tabla en Oracle
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Integer idOrden; // <--- CAMBIO: De Long a Integer

    @Column(name = "PRODUCTO")
    private String producto;

    @Column(name = "PRECIO")
    private double precio;

    @Column(name = "ESTADO")
    private String estado;

    // IMPORTANTE: Constructor vacío obligatorio para JPA
    public Orden() {
    }

    // Constructor actualizado a Integer
    public Orden(Integer idOrden, String producto, double precio, String estado) {
        this.idOrden = idOrden;
        this.producto = producto;
        this.precio = precio;
        this.estado = estado;
    }

    // Getters actualizados a Integer
    public Integer getIdOrden() { return idOrden; }
    public String getProducto() { return producto; }
    public double getPrecio() { return precio; }
    public String getEstado() { return estado; }

    // Setters actualizados a Integer
    public void setIdOrden(Integer idOrden) { this.idOrden = idOrden; }
    public void setProducto(String producto) { this.producto = producto; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setEstado(String estado) { this.estado = estado; }
}