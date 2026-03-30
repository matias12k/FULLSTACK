package com.duoc.hotel_reservas;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    // Cambiamos el tercer registro a 'true' para que aparezcan 3 en el navegador
    private static List<Reserva> listaReservas = new ArrayList<>(Arrays.asList(
        new Reserva(1, "Huésped Alfa", "2026-05-01", true),
        new Reserva(2, "Huésped Beta", "2026-05-05", true),
        new Reserva(3, "Huésped Gamma", "2026-05-10", true) 
    ));

    @GetMapping("/disponibilidad")
    public List<Reserva> consultarDisponibilidad() {
        return listaReservas.stream()
                .filter(Reserva::isActiva)
                .toList();
    }

    @GetMapping("/crear")
    public String crearReserva(@RequestParam int id, @RequestParam String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Error: El nombre del huésped no puede estar vacío.";
        }
        Reserva nueva = new Reserva(id, nombre, "2026-06-01", true);
        listaReservas.add(nueva);
        return "Reserva creada exitosamente para: " + nombre;
    }

    @GetMapping("/cancelar/{id}")
    public String cancelarReserva(@PathVariable int id) {
        for (Reserva r : listaReservas) {
            if (r.getId() == id) {
                r.setActiva(false);
                return "La reserva con ID " + id + " ha sido cancelada.";
            }
        }
        return "Error: No se encontró ninguna reserva con el ID " + id;
    }
}