package com.julia.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julia.core.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
