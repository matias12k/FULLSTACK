package com.duoc.hotel_reservas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelReservasApplicationTests {

    @Test
    void contextLoads() {
        // Verifica que el microservicio inicie correctamente
    }

    // PRUEBA 1: Validación de creación y consistencia de datos
    @Test
    public void testCreacionReserva() {
        Reserva reserva = new Reserva(1, "B. Barraza", "2026-05-10", true);
        assertNotNull(reserva);
        assertEquals("B. Barraza", reserva.getHuesped());
    }

    // PRUEBA 2: Validación de estado (Activa/Inactiva)
    @Test
    public void testEstadoReserva() {
        Reserva reserva = new Reserva();
        reserva.setActiva(false);
        assertFalse(reserva.isActiva());
    }

    // PRUEBA 3: Validación de integridad de la fecha
    @Test
    public void testFechaReserva() {
        Reserva reserva = new Reserva();
        reserva.setFecha("2026-06-15");
        assertNotNull(reserva.getFecha());
    }

    // PRUEBA 4: Validación de ID para la base de datos Oracle
    @Test
    public void testAsignacionId() {
        Reserva reserva = new Reserva();
        reserva.setId(100);
        assertEquals(100, reserva.getId());
    }
}