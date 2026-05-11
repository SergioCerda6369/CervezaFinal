package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.RecetasDTO;
import com.cerveza.cerveza.model.Recetas;
import com.cerveza.cerveza.repository.RecetasRepository;

@Service
public class RecetaService {

    @Autowired
    private RecetasRepository repository;

    public List<RecetasDTO> obtenerTodos() {
        List<Recetas> lista = repository.findAll();
        List<RecetasDTO> dtos = new ArrayList<>();
        for (Recetas r : lista) {
            dtos.add(convertirADTO(r));
        }
        return dtos;
    }

    public RecetasDTO guardar(Recetas r) {
        return convertirADTO(repository.save(r));
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private RecetasDTO convertirADTO(Recetas r) {
        RecetasDTO dto = new RecetasDTO();
        dto.setId_receta(r.getId_receta());
        dto.setNombre_receta(r.getNombre_receta());
        dto.setTipo_cerveza(r.getTipo_cerveza());
        dto.setTiempo_coccion(r.getTiempo_coccion());
        return dto;
    }

}
