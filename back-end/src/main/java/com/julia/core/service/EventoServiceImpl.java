package com.julia.core.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julia.core.model.Evento;
import com.julia.core.repository.EventoRepository;
import com.julia.core.service.interfaces.EventoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Evento save(Evento object) {
        return this.eventoRepository.save(object);
    }

    @Override
    public List<Evento> list() {
        return this.eventoRepository.findAll();
    }

    @Override
    public Evento searchById(Long id) {
        Optional<Evento> evento = this.eventoRepository.findById(id);

        if (!evento.isPresent()) {
            throw new EntityNotFoundException("Não foi possivel encontrar o evento com o id: " + id);
        }

        return evento.get();
    }

    @Override
    public Evento update(Evento object) {

        this.searchById(object.getId());

        Evento evento = this.searchById(object.getId());

        if (Objects.nonNull(object)) {
            BeanUtils.copyProperties(object, evento, "id");

            this.save(object);
        }

        return object;
    }

    @Override
    public void deleteById(Long id) {
        this.searchById(id);
        this.eventoRepository.deleteById(id);
    }

}
