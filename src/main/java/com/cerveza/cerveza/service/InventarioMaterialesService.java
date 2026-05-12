package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.InventarioMaterialesDTO;
import com.cerveza.cerveza.model.InventarioMateriales;
import com.cerveza.cerveza.repository.InventarioMaterialesRepository;

@Service
public class InventarioMaterialesService {

    @Autowired
    private InventarioMaterialesRepository repository;

    public List<InventarioMaterialesDTO> obtenerTodos() {
        List<InventarioMateriales> lista = repository.findAll();
        List<InventarioMaterialesDTO> dtos = new ArrayList<>();
        for (InventarioMateriales m : lista) {
            dtos.add(convertirADTO(m));
        }
        return dtos;
    }

    public InventarioMaterialesDTO guardar(InventarioMateriales m) {
        return convertirADTO(repository.save(m));
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private InventarioMaterialesDTO convertirADTO(InventarioMateriales m) {
        InventarioMaterialesDTO dto = new InventarioMaterialesDTO();
        dto.setIdMaterial(m.getIdMaterial());
        dto.setNombreMaterial(m.getNombreMaterial());
        dto.setCantidadStock(m.getCantidadStock());
        dto.setNombreProveedor(m.getNombreProveedor());
        return dto;
    }

}
