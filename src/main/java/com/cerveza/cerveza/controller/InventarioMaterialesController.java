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

import com.cerveza.cerveza.dto.InventarioMaterialesDTO;
import com.cerveza.cerveza.model.InventarioMateriales;
import com.cerveza.cerveza.service.InventarioMaterialesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/materiales")
@CrossOrigin(origins = "*")

public class InventarioMaterialesController {

    @Autowired
    private InventarioMaterialesService materialesService;

    @GetMapping
    public ResponseEntity<List<InventarioMaterialesDTO>> listar() {
        return new ResponseEntity<>(materialesService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventarioMaterialesDTO> guardar(@Valid @RequestBody InventarioMateriales material) {
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
