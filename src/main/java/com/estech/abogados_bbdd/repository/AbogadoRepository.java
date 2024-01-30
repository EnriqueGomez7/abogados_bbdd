package com.estech.abogados_bbdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estech.abogados_bbdd.model.Abogado;

public interface AbogadoRepository extends JpaRepository<Abogado, String> {
    
}
