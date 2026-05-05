package com.duoc.hotel_reservas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservaTest {

    @Test
    void testCreacionReserva() {
        Reserva r = new Reserva();
        r.setHuesped("Juan Perez");
        assertEquals("Juan Perez", r.getHuesped());
    }

    @Test
    void testValidacionHuespedVacio() {
        Reserva r = new Reserva();
        r.setHuesped(""); // Nombre vacío
        
        assertThrows(RuntimeException.class, () -> {
            if(r.getHuesped().isEmpty()) throw new RuntimeException("Error: El nombre del huésped no puede estar vacío.");
        });
    }
}