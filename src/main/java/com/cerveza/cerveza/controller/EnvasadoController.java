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

import com.cerveza.cerveza.dto.EnvasadoDTO;
import com.cerveza.cerveza.model.Envasado;
import com.cerveza.cerveza.service.EnvasadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/envasado")
@CrossOrigin(origins = "*")
public class EnvasadoController {

    @Autowired
    private EnvasadoService envasadoService;

    @GetMapping
    public ResponseEntity<List<EnvasadoDTO>> listar() {
        return new ResponseEntity<>(envasadoService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnvasadoDTO> guardar(@Valid @RequestBody Envasado envasado) {
        return new ResponseEntity<>(envasadoService.guardar(envasado), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (envasadoService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
