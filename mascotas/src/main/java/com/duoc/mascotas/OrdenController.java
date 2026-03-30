package com.duoc.mascotas;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class OrdenController {

    // Requisito: Iniciamos con 3 registros de información
    private static List<Orden> listaOrdenes = new ArrayList<>(Arrays.asList(
        new Orden(101, "Alimento Premium Perro", 25000.0, "Pendiente"),
        new Orden(102, "Rascador para Gatos", 15000.0, "Enviado"),
        new Orden(103, "Cama Ortopédica Mascota", 35000.0, "Procesando")
    ));

    @GetMapping("/estado")
    public List<Orden> consultarEstados() {
        return listaOrdenes;
    }

    @GetMapping("/crear")
    public String crearOrden(@RequestParam int id, @RequestParam String prod, @RequestParam double precio) {
        // Validación de consistencia
        if (precio <= 0) {
            return "Error: El precio debe ser mayor a cero.";
        }
        
        listaOrdenes.add(new Orden(id, prod, precio, "Pendiente"));
        return "Orden creada: " + prod;
    }
}