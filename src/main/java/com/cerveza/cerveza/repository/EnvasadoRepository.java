package com.cerveza.cerveza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerveza.cerveza.model.Envasado;

@Repository
public interface EnvasadoRepository extends JpaRepository <Envasado, Integer>{

}
