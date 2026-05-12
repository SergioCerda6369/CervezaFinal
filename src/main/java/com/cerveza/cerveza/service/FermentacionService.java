package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.FermentacionDTO;
import com.cerveza.cerveza.model.Fermentacion;
import com.cerveza.cerveza.repository.FermentacionRepository;

@Service
public class FermentacionService {

    @Autowired
    private FermentacionRepository fermentacionRepository;

    public List<FermentacionDTO> obtenerTodos() {
        List<Fermentacion> lista = fermentacionRepository.findAll();
        List<FermentacionDTO> dtos = new ArrayList<>();
        for (Fermentacion f : lista) {
            dtos.add(convertirADTO(f));
        }
        return dtos;
    }

    public FermentacionDTO guardar(Fermentacion f) {
        return convertirADTO(fermentacionRepository.save(f));
    }

    public boolean eliminar(Integer id) {
        if (fermentacionRepository.existsById(id)) {
            fermentacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private FermentacionDTO convertirADTO(Fermentacion f) {
        FermentacionDTO dto = new FermentacionDTO();
        dto.setIdFermentacion(f.getIdFermentacion());
        dto.setCodigoTanque(f.getCodigoTanque());
        dto.setTemperaturaActual(f.getTemperaturaActual());
        return dto;
    }

}
