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

import com.cerveza.cerveza.dto.DistribucionDTO;
import com.cerveza.cerveza.model.Distribucion;
import com.cerveza.cerveza.service.DistribucionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/distribucion")
@CrossOrigin(origins = "*")
public class DistribucionController {

    @Autowired
    private DistribucionService distribucionService;

    @GetMapping
    public ResponseEntity<List<DistribucionDTO>> listar() {
        return new ResponseEntity<>(distribucionService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DistribucionDTO> guardar(@Valid @RequestBody Distribucion distribucion) {
        return new ResponseEntity<>(distribucionService.guardar(distribucion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (distribucionService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
