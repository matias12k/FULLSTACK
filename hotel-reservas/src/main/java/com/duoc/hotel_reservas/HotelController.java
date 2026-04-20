package com.duoc.hotel_reservas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    @Autowired
    private ReservaRepository reservaRepository;

    // 1. LISTAR (GET) - Ahora busca en Oracle Cloud
    @GetMapping("/listar")
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    // 2. CREAR (POST) - Ahora guarda en Oracle Cloud
    // Usamos @RequestBody para que sea un POST profesional
    @PostMapping("/crear")
    public Reserva crear(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // 3. ACTUALIZAR (PUT) - Requisito de alta complejidad
    @PutMapping("/actualizar/{id}")
    public Reserva actualizar(@PathVariable int id, @RequestBody Reserva detalles) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la reserva con ID: " + id));
        
        reserva.setHuesped(detalles.getHuesped());
        reserva.setFecha(detalles.getFecha());
        reserva.setActiva(detalles.isActiva());
        
        return reservaRepository.save(reserva);
    }

    // 4. ELIMINAR (DELETE)
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        reservaRepository.deleteById(id);
        return "Reserva " + id + " eliminada correctamente.";
    }
}