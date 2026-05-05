package com.duoc.hotel_reservas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Clase que representa la entidad de Reserva mapeada a Oracle Cloud.
 */
@Entity
@Table(name = "RESERVAS")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Permite que Oracle asigne el ID automáticamente
    @Column(name = "ID")
    private Integer id; // Cambiado de int a Integer para mejor compatibilidad con JPA

    @Column(name = "HUESPED")
    private String huesped;

    @Column(name = "FECHA")
    private String fecha;

    @Column(name = "ACTIVA")
    private boolean activa;

    // Constructor vacío obligatorio
    public Reserva() {
    }

    // Constructor con parámetros actualizado
    public Reserva(Integer id, String huesped, String fecha, boolean activa) {
        this.id = id;
        this.huesped = huesped;
        this.fecha = fecha;
        this.activa = activa;
    }

    // Getters
    public Integer getId() { return id; }
    public String getHuesped() { return huesped; }
    public String getFecha() { return fecha; }
    public boolean isActiva() { return activa; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setHuesped(String huesped) { this.huesped = huesped; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setActiva(boolean activa) { this.activa = activa; }
}