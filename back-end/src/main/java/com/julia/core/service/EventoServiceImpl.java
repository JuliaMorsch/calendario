package com.julia.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julia.core.model.Evento;
import com.julia.core.repository.EventoRepository;
import com.julia.core.service.interfaces.EventoService;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchById'");
    }

    @Override
    public Evento update(Evento object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
