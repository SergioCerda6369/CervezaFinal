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

import com.cerveza.cerveza.dto.MantenimientoDTO;
import com.cerveza.cerveza.model.Mantenimiento;
import com.cerveza.cerveza.service.MantenimientoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/mantenimiento")
@CrossOrigin(origins = "*")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping
    public ResponseEntity<List<MantenimientoDTO>> listar() {
        return new ResponseEntity<>(mantenimientoService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MantenimientoDTO> guardar(@Valid @RequestBody Mantenimiento mantenimiento) {
        return new ResponseEntity<>(mantenimientoService.guardar(mantenimiento), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (mantenimientoService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
