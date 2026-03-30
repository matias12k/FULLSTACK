package com.duoc.hotel_reservas;

/**
 * Clase que representa la entidad de Reserva.
 * Contiene los datos básicos para identificar al huésped y el estado de su estancia.
 */
public class Reserva {
    private int id;
    private String huesped;
    private String fecha;
    private boolean activa;

    // Constructor: Sirve para crear el objeto con datos iniciales
    public Reserva(int id, String huesped, String fecha, boolean activa) {
        this.id = id;
        this.huesped = huesped;
        this.fecha = fecha;
        this.activa = activa;
    }

    // Getters: Permiten que Spring convierta los datos a formato JSON para el navegador
    public int getId() { return id; }
    public String getHuesped() { return huesped; }
    public String getFecha() { return fecha; }
    public boolean isActiva() { return activa; }

    // Setter: Permite modificar el estado de la reserva (ej. para cancelarla)
    public void setActiva(boolean activa) { this.activa = activa; }
}