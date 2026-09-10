package com.udea.reservas.plataformareservas.reservas.repository;

import com.udea.reservas.plataformareservas.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    boolean existsByHorario_IdAndFechaAndEstado(Integer horarioId, LocalDate fecha, String estado);
}