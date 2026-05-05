package com.duoc.mascotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class OrdenController {

    @Autowired
    private OrdenRepository ordenRepository; // Conexión a la base de datos

    // 1. LISTAR (GET)
    @GetMapping("/listar")
    public List<Orden> listarTodas() {
        return ordenRepository.findAll();
    }

    // 2. CREAR (POST)
    @PostMapping("/crear")
    public Orden crearOrden(@RequestBody Orden nuevaOrden) {
        if (nuevaOrden.getPrecio() <= 0) {
            throw new RuntimeException("Error: El precio debe ser mayor a cero.");
        }
        return ordenRepository.save(nuevaOrden);
    }

    // 3. CONSULTAR POR ID (GET) con HATEOAS usando Integer
    @GetMapping("/consultar/{id}")
    public org.springframework.hateoas.EntityModel<Orden> consultarPorId(@PathVariable Integer id) {
        Orden orden = ordenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + id));

        // Creamos el EntityModel para agregar los enlaces HATEOAS
        return org.springframework.hateoas.EntityModel.of(orden,
            org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo(
                org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn(OrdenController.class).consultarPorId(id)).withSelfRel(),
            org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo(
                org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn(OrdenController.class).listarTodas()).withRel("lista-completa"));
    }
}