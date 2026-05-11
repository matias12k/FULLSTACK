package com.duoc.mascotas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MascotasApplicationTests {

    @Test
    void contextLoads() {
        // Verifica que el microservicio de Mascotas cargue correctamente
    }

    // PRUEBA 1: Validación de creación de Orden (Se eliminó el 'L' para usar Integer)
    @Test
    public void testCreacionOrden() {
        // Se usa 1 en lugar de 1L para coincidir con el constructor de Integer
        Orden orden = new Orden(1, "Alimento Gato Premium", 15000.0, "PENDIENTE");
        assertNotNull(orden);
        assertEquals("Alimento Gato Premium", orden.getProducto());
    }

    // PRUEBA 2: Validación de estado de la orden
    @Test
    public void testEstadoOrden() {
        Orden orden = new Orden();
        orden.setEstado("ENTREGADO");
        assertEquals("ENTREGADO", orden.getEstado());
    }

    // PRUEBA 3: Validación de integridad del precio
    @Test
    public void testPrecioOrden() {
        Orden orden = new Orden();
        orden.setPrecio(25990.0);
        assertTrue(orden.getPrecio() > 0);
    }

    // PRUEBA 4: Validación de ID (Se eliminó el 'L' y se cambió setIdOrden a Integer)
    @Test
    public void testAsignacionIdOrden() {
        Orden orden = new Orden();
        orden.setIdOrden(500); // Antes era 500L, ahora es Integer
        // Comparamos Integer con Integer directamente
        assertEquals(500, orden.getIdOrden().intValue());
    }
}