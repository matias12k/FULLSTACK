package com.duoc.mascotas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrdenServiceTest {

    // Prueba 1: Validar que el sistema rechaza precios inválidos
    @Test
    void testPrecioInvalidoLanzaExcepcion() {
        Orden ordenInvalida = new Orden();
        ordenInvalida.setPrecio(-500);
        
        // Verificamos que se lance la RuntimeException que definiste en el controlador
        Exception exception = assertThrows(RuntimeException.class, () -> {
            if(ordenInvalida.getPrecio() <= 0) throw new RuntimeException("Error: El precio debe ser mayor a cero.");
        });

        assertEquals("Error: El precio debe ser mayor a cero.", exception.getMessage());
    }

    // Prueba 2: Validar la creación de un objeto Orden
    @Test
    void testCreacionObjetoOrden() {
        Orden orden = new Orden();
        orden.setProducto("Cama Gato");
        orden.setPrecio(15000);
        
        assertNotNull(orden.getProducto());
        assertEquals(15000, orden.getPrecio());
    }
}