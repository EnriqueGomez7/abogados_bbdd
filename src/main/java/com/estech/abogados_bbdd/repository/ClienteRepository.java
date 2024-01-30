package com.estech.abogados_bbdd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estech.abogados_bbdd.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByAbogadoCodigoColegiado(String codigoColegiado);
}
