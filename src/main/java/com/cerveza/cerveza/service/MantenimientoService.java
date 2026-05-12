package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.MantenimientoDTO;
import com.cerveza.cerveza.model.Mantenimiento;
import com.cerveza.cerveza.repository.MantenimientoRepository;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoRepository repository;

    public List<MantenimientoDTO> obtenerTodos() {
        List<Mantenimiento> lista = repository.findAll();
        List<MantenimientoDTO> dtos = new ArrayList<>();
        for (Mantenimiento m : lista) {
            dtos.add(convertirADTO(m));
        }
        return dtos;
    }

    public MantenimientoDTO guardar(Mantenimiento m) {
        return convertirADTO(repository.save(m));
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private MantenimientoDTO convertirADTO(Mantenimiento m) {
        MantenimientoDTO dto = new MantenimientoDTO();
        dto.setIdMantenimiento(m.getIdMantenimiento());
        dto.setTipoEquipo(m.getTipoEquipo());
        dto.setCodigoEquipo(m.getCodigoEquipo());
        dto.setEstadoEquipo(m.getEstadoEquipo());
        dto.setEstadoMantenimiento(m.getEstadoMantenimiento());

        if (m.getTanque() != null) {
        dto.setCodigoTanqueMantenimiento(m.getTanque().getCodigoTanque());
        }
        return dto;
    }

}
