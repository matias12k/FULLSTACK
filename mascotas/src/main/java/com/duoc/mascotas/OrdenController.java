package com.duoc.mascotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class OrdenController {

    @Autowired
    private OrdenRepository ordenRepository; // Conexión a la base de datos

    // 1. LISTAR (GET) - Ahora lee desde Oracle Cloud
    // URL para Postman: http://localhost:8082/api/mascotas/listar
    @GetMapping("/listar")
    public List<Orden> listarTodas() {
        return ordenRepository.findAll();
    }

    // 2. CREAR (POST) - Ahora guarda en Oracle Cloud
    // URL para Postman: http://localhost:8082/api/mascotas/crear
    @PostMapping("/crear")
    public Orden crearOrden(@RequestBody Orden nuevaOrden) {
        // La validación de precio se mantiene, pero sobre el objeto recibido
        if (nuevaOrden.getPrecio() <= 0) {
            throw new RuntimeException("Error: El precio debe ser mayor a cero.");
        }
        return ordenRepository.save(nuevaOrden);
    }
}