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

import com.cerveza.cerveza.dto.Inventario_MaterialesDTO;
import com.cerveza.cerveza.model.Inventario_Materiales;
import com.cerveza.cerveza.service.Inventario_MaterialesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/materiales")
@CrossOrigin(origins = "*")

public class Inventario_MaterialesController {

    @Autowired
    private Inventario_MaterialesService materialesService;

    @GetMapping
    public ResponseEntity<List<Inventario_MaterialesDTO>> listar() {
        return new ResponseEntity<>(materialesService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Inventario_MaterialesDTO> guardar(@Valid @RequestBody Inventario_Materiales material) {
        return new ResponseEntity<>(materialesService.guardar(material), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (materialesService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
