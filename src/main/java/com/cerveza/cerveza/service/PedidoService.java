package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.PedidoDTO;
import com.cerveza.cerveza.model.Pedido;
import com.cerveza.cerveza.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoDTO> obtenerTodos() {
        List<Pedido> lista = pedidoRepository.findAll();
        List<PedidoDTO> dtos = new ArrayList<>();
        for (Pedido p : lista) {
            dtos.add(convertirADTO(p));
        }
        return dtos;
    }

    public PedidoDTO guardar(Pedido p) {
        return convertirADTO(pedidoRepository.save(p));
    }

    public boolean eliminar(Integer id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private PedidoDTO convertirADTO(Pedido p) {
        PedidoDTO dto = new PedidoDTO();
        dto.setIdPedido(p.getIdPedido());
        dto.setCliente(p.getCliente());
        dto.setCantidadSolicitada(p.getCantidadSolicitada());
        dto.setTotalVenta(p.getTotalVenta());
        dto.setEstadoPedido(p.getEstadoPedido());
        if (p.getProducto() != null) {
            dto.setNombreProducto(p.getProducto().getNombreCerveza());
        }
        return dto;
    }

}
