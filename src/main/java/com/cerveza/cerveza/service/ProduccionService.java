package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.ProduccionDTO;
import com.cerveza.cerveza.model.Produccion;
import com.cerveza.cerveza.repository.ProduccionRepository;

@Service
public class ProduccionService {

    @Autowired
    private ProduccionRepository repository;

    public List<ProduccionDTO> obtenerTodos() {
        List<Produccion> lista = repository.findAll();
        List<ProduccionDTO> dtos = new ArrayList<>();
        for (Produccion p : lista) {
            dtos.add(convertirADTO(p));
        }
        return dtos;
    }

    public ProduccionDTO guardar(Produccion p) {
        return convertirADTO(repository.save(p));
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private ProduccionDTO convertirADTO(Produccion p) {
        ProduccionDTO dto = new ProduccionDTO();
        dto.setId_produccion(p.getId_produccion());
        dto.setEstado_produccion(p.getEstado_produccion());
        dto.setResponsable_produccion(p.getResponsable_produccion());
        
        if (p.getReceta() != null) {
        dto.setNombre_receta(p.getReceta().getNombre_receta());
    }
        return dto;
    }

}
