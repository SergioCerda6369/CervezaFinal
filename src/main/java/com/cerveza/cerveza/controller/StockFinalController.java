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

import com.cerveza.cerveza.dto.StockFinalDTO;
import com.cerveza.cerveza.model.StockFinal;
import com.cerveza.cerveza.service.StockFinalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "*")

public class StockFinalController {

    @Autowired
    private StockFinalService stockService;

    @GetMapping
    public ResponseEntity<List<StockFinalDTO>> listar() {
        return new ResponseEntity<>(stockService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockFinalDTO> guardar(@Valid @RequestBody StockFinal stock) {
        return new ResponseEntity<>(stockService.guardar(stock), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (stockService.eliminar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
