package com.duoc.mascotas;

public class Orden {
    private int idOrden;
    private String producto;
    private double precio;
    private String estado;

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
    
    public void setEstado(String estado) { this.estado = estado; }
}