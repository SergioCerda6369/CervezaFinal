package com.cerveza.cerveza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produccion")

public class Produccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduccion;

    @NotBlank(message = "La produccion debe de tener un estado visible.")
    @Size(min = 3, max = 255, message = "El estado de la produccion debe de tener entre 3 y 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String estadoProduccion;

    @NotBlank(message = "Debe de haber un responsable de supervisar la produccion.")
    @Size(min = 3, max = 50, message = "El nombre del responsable debe de tener entre 3 y 50 caracteres.")
    @Column(nullable = false, length = 50)
    private String responsableProduccion;

    @ManyToOne
    @JoinColumn(name = "id_receta", nullable = false)
    private Recetas receta;

    
}
