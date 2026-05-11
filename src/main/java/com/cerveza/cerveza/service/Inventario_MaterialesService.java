package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.Inventario_MaterialesDTO;
import com.cerveza.cerveza.model.Inventario_Materiales;
import com.cerveza.cerveza.repository.Inventario_MaterialesRepository;

@Service
public class Inventario_MaterialesService {

    @Autowired
    private Inventario_MaterialesRepository repository;

    public List<Inventario_MaterialesDTO> obtenerTodos() {
        List<Inventario_Materiales> lista = repository.findAll();
        List<Inventario_MaterialesDTO> dtos = new ArrayList<>();
        for (Inventario_Materiales m : lista) {
            dtos.add(convertirADTO(m));
        }
        return dtos;
    }

    public Inventario_MaterialesDTO guardar(Inventario_Materiales m) {
        return convertirADTO(repository.save(m));
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private Inventario_MaterialesDTO convertirADTO(Inventario_Materiales m) {
        Inventario_MaterialesDTO dto = new Inventario_MaterialesDTO();
        dto.setId_material(m.getId_material());
        dto.setNombre_material(m.getNombre_material());
        dto.setCantidad_stock(m.getCantidad_stock());
        dto.setNombre_proveedor(m.getNombre_proveedor());
        return dto;
    }

}
