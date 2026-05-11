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

import com.cerveza.cerveza.dto.RecetasDTO;
import com.cerveza.cerveza.model.Recetas;
import com.cerveza.cerveza.service.RecetaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/receta")
@CrossOrigin(origins = "*")

public class RecestasController {

    @Autowired
    private RecetaService recetasService;

    @GetMapping
    public ResponseEntity<List<RecetasDTO>> listar() {
        return new ResponseEntity<>(recetasService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecetasDTO> guardar(@Valid @RequestBody Recetas receta) {
        return new ResponseEntity<>(recetasService.guardar(receta), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (recetasService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
