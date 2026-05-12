package com.cerveza.cerveza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerveza.cerveza.model.InventarioMateriales;


public interface InventarioMaterialesRepository extends JpaRepository<InventarioMateriales, Integer> {

    List<InventarioMateriales> findByIdMaterial(Integer id_material);

    

}
