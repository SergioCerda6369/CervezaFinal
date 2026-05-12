package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.EnvasadoDTO;
import com.cerveza.cerveza.model.Envasado;
import com.cerveza.cerveza.repository.EnvasadoRepository;

@Service
public class EnvasadoService {

    @Autowired
    private EnvasadoRepository envasadoRepository;

    public List<EnvasadoDTO> obtenerTodos() {
        List<Envasado> lista = envasadoRepository.findAll();
        List<EnvasadoDTO> dtos = new ArrayList<>();
        for (Envasado e : lista) {
            dtos.add(convertirADTO(e));
        }
        return dtos;
    }

    public EnvasadoDTO guardar(Envasado e) {
        return convertirADTO(envasadoRepository.save(e));
    }

    public boolean eliminar(Integer id) {
        if (envasadoRepository.existsById(id)) {
            envasadoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private EnvasadoDTO convertirADTO(Envasado e) {
        EnvasadoDTO dto = new EnvasadoDTO();
        dto.setIdEnvasado(e.getIdEnvasado());
        dto.setTipoEnvase(e.getTipoEnvase());
        dto.setCantidadEnvases(e.getCantidadEnvases());
        if(e.getProducto() != null) dto.setNombreProductoFinal(e.getProducto().getNombreCerveza());
        return dto;
    }

}
