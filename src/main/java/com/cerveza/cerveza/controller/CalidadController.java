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

import com.cerveza.cerveza.dto.CalidadDTO;
import com.cerveza.cerveza.model.Calidad;
import com.cerveza.cerveza.service.CalidadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/calidad")
@CrossOrigin(origins = "*")

public class CalidadController {

    @Autowired
    private CalidadService calidadService;

    @GetMapping
    public ResponseEntity<List<CalidadDTO>> listar() {
        return new ResponseEntity<>(calidadService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CalidadDTO> guardar(@Valid @RequestBody Calidad calidad) {
        return new ResponseEntity<>(calidadService.guardar(calidad), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (calidadService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
