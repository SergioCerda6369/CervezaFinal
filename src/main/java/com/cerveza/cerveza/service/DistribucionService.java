package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.DistribucionDTO;
import com.cerveza.cerveza.model.Distribucion;
import com.cerveza.cerveza.repository.DistribucionRepository;

@Service
public class DistribucionService {
    
    @Autowired
    private DistribucionRepository distribucionRepository;

    public List<DistribucionDTO> obtenerTodos() {
        List<Distribucion> lista = distribucionRepository.findAll();
        List<DistribucionDTO> dtos = new ArrayList<>();
        for (Distribucion d : lista) {
            dtos.add(convertirADTO(d));
        }
        return dtos;
    }

    public DistribucionDTO guardar(Distribucion d) {
        return convertirADTO(distribucionRepository.save(d));
    }

    public boolean eliminar(Integer id) {
        if (distribucionRepository.existsById(id)) {
            distribucionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private DistribucionDTO convertirADTO(Distribucion d) {
        DistribucionDTO dto = new DistribucionDTO();
        dto.setId_distribucion(d.getId_distribucion());
        dto.setPatente_camion(d.getPatente_camion());
        dto.setNombre_conductor(d.getNombre_conductor());
        dto.setEstado_distribucion(d.getEstado_distribucion());
        return dto;
    }

}
