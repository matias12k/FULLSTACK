package com.duoc.hotel_reservas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

/**
 * Clase que representa la entidad de Reserva mapeada a Oracle Cloud.
 */
@Entity
@Table(name = "RESERVAS") // Nombre exacto de la tabla en tu DB
public class Reserva {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "HUESPED")
    private String huesped;

    @Column(name = "FECHA")
    private String fecha;

    @Column(name = "ACTIVA")
    private boolean activa;

    // IMPORTANTE: Constructor vacío obligatorio para que JPA funcione
    public Reserva() {
    }

    // Constructor con parámetros (lo mantenemos para tu lógica)
    public Reserva(int id, String huesped, String fecha, boolean activa) {
        this.id = id;
        this.huesped = huesped;
        this.fecha = fecha;
        this.activa = activa;
    }

    // Getters
    public int getId() { return id; }
    public String getHuesped() { return huesped; }
    public String getFecha() { return fecha; }
    public boolean isActiva() { return activa; }

    // Setters (Agregamos el resto para que Spring pueda llenar el objeto desde el JSON de Postman)
    public void setId(int id) { this.id = id; }
    public void setHuesped(String huesped) { this.huesped = huesped; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setActiva(boolean activa) { this.activa = activa; }
}