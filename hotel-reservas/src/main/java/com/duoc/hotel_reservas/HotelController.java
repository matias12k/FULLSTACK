package com.duoc.hotel_reservas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    @Autowired
    private ReservaRepository reservaRepository;

    // 1. LISTAR (GET) con HATEOAS
    @GetMapping("/listar")
    public CollectionModel<EntityModel<Reserva>> listarTodas() {
        List<EntityModel<Reserva>> reservas = reservaRepository.findAll().stream()
            .map(reserva -> EntityModel.of(reserva,
                linkTo(methodOn(HotelController.class).actualizar(reserva.getId(), null)).withRel("actualizar"),
                linkTo(methodOn(HotelController.class).listarTodas()).withRel("lista-completa")))
            .collect(Collectors.toList());

        return CollectionModel.of(reservas, 
            linkTo(methodOn(HotelController.class).listarTodas()).withSelfRel());
    }

    // 2. CREAR (POST) con HATEOAS
    @PostMapping("/crear")
    public EntityModel<Reserva> crear(@RequestBody Reserva reserva) {
        // Validación de negocio (Para el test unitario posterior)
        if (reserva.getHuesped() == null || reserva.getHuesped().isEmpty()) {
            throw new RuntimeException("Error: El nombre del huésped no puede estar vacío.");
        }
        
        Reserva guardada = reservaRepository.save(reserva);
        return EntityModel.of(guardada,
            linkTo(methodOn(HotelController.class).listarTodas()).withRel("ver-todas"));
    }

    // 3. ACTUALIZAR (PUT)
    @PutMapping("/actualizar/{id}")
    public EntityModel<Reserva> actualizar(@PathVariable int id, @RequestBody Reserva detalles) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la reserva con ID: " + id));
        
        reserva.setHuesped(detalles.getHuesped());
        reserva.setFecha(detalles.getFecha());
        reserva.setActiva(detalles.isActiva());
        
        Reserva actualizada = reservaRepository.save(reserva);
        return EntityModel.of(actualizada,
            linkTo(methodOn(HotelController.class).listarTodas()).withRel("lista-completa"));
    }

    // 4. ELIMINAR (DELETE)
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        reservaRepository.deleteById(id);
        return "Reserva " + id + " eliminada correctamente.";
    }

    // 5. CONSULTAR POR ID (GET) con HATEOAS
    @GetMapping("/consultar/{id}")
    public EntityModel<Reserva> consultarPorId(@PathVariable int id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));

        return EntityModel.of(reserva,
            linkTo(methodOn(HotelController.class).consultarPorId(id)).withSelfRel(),
            linkTo(methodOn(HotelController.class).listarTodas()).withRel("lista-completa"));
    }
}