package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.CalidadDTO;
import com.cerveza.cerveza.model.Calidad;
import com.cerveza.cerveza.repository.CalidadRepository;

@Service
public class CalidadService {
    @Autowired
    private CalidadRepository calidadRepository;

    public List<CalidadDTO> obtenerTodos() {
        List<Calidad> lista = calidadRepository.findAll();
        List<CalidadDTO> listaDTO = new ArrayList<>();
        for (Calidad c : lista) {
            listaDTO.add(convertirADTO(c));
        }
        return listaDTO;
    }

    public CalidadDTO buscarPorId(Integer id) {
        Calidad c = calidadRepository.findById(id).orElse(null);
        return (c != null) ? convertirADTO(c) : null;
    }

    public CalidadDTO guardar(Calidad c) {
        return convertirADTO(calidadRepository.save(c));
    }

    public boolean eliminar(Integer id) {
        if (calidadRepository.existsById(id)) {
            calidadRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private CalidadDTO convertirADTO(Calidad c) {
        CalidadDTO dto = new CalidadDTO();
        dto.setId_calidad(c.getId_calidad());
        dto.setCantidad_ph(c.getCantidad_ph());
        dto.setControl_calidad(c.isControl_calidad());

        if (c.getLote() != null) {
        dto.setEstadoLoteProduccion(c.getLote().getEstado_produccion());
    }
        return dto;
    }

}
