package com.estech.abogados_bbdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estech.abogados_bbdd.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
