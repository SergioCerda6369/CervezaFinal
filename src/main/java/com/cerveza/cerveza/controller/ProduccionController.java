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

import com.cerveza.cerveza.dto.ProduccionDTO;
import com.cerveza.cerveza.model.Produccion;
import com.cerveza.cerveza.service.ProduccionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produccion")
@CrossOrigin(origins = "*")

public class ProduccionController {


    @Autowired
    private ProduccionService produccionService;

    @GetMapping
    public ResponseEntity<List<ProduccionDTO>> listar() {
        return new ResponseEntity<>(produccionService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProduccionDTO> guardar(@Valid @RequestBody Produccion produccion) {
        return new ResponseEntity<>(produccionService.guardar(produccion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (produccionService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
