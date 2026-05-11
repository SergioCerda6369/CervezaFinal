package com.cerveza.cerveza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerveza.cerveza.dto.PedidoDTO;
import com.cerveza.cerveza.model.Pedido;
import com.cerveza.cerveza.service.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")

public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listar() {
        return new ResponseEntity<>(pedidoService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> guardar(@Valid @RequestBody Pedido pedido) {
        return new ResponseEntity<>(pedidoService.guardar(pedido), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (pedidoService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
