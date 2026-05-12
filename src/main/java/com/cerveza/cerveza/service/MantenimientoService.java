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
        dto.setId_mantenimiento(m.getId_mantenimiento());
        dto.setTipo_equipo(m.getTipo_equipo());
        dto.setCodigo_equipo(m.getCodigo_equipo());
        dto.setEstado_equipo(m.getEstado_equipo());
        dto.setEstado_mantenimiento(m.getEstado_mantenimiento());

        if (m.getTanque() != null) {
        dto.setCodigoTanqueMantenimiento(m.getTanque().getCodigo_tanque());
        }
        return dto;
    }

}
