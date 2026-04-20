package com.duoc.hotel_reservas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    // Aquí ya tienes listos los métodos:
    // .findAll() -> para el GET
    // .save()    -> para el POST y PUT
    // .deleteById() -> para el DELETE
}