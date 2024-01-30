package com.estech.abogados_bbdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estech.abogados_bbdd.DTO.AbogadoDTO;
import com.estech.abogados_bbdd.DTO.ClienteDTO;
import com.estech.abogados_bbdd.model.Abogado;
import com.estech.abogados_bbdd.model.Cliente;
import com.estech.abogados_bbdd.repository.AbogadoRepository;
import com.estech.abogados_bbdd.repository.ClienteRepository;

@RestController
@RequestMapping("/api/abogados")
public class AbogadoController {

     @Autowired
    private AbogadoRepository abogadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/{codigoColegiado}/clientes")
    public ResponseEntity<Void> agregarCliente(@PathVariable String codigoColegiado, @RequestBody ClienteDTO clienteDto) {
        Abogado abogado = abogadoRepository.findById(codigoColegiado).orElse(null);
        if (abogado != null) {
            Cliente cliente = new Cliente();
            cliente.setNombreCliente(clienteDto.getNombreCliente());
            cliente.setApellidoCliente(clienteDto.getApellidoCliente());
            cliente.setAbogado(abogado);
            clienteRepository.save(cliente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{codigoColegiado}")
    public ResponseEntity<AbogadoDTO> obtenerAbogadoConClientes(@PathVariable String codigoColegiado) {
        Abogado abogado = abogadoRepository.findById(codigoColegiado).orElse(null);
        if (abogado != null) {
            AbogadoDTO abogadoDto = new AbogadoDTO();
            abogadoDto.setCodigoColegiado(abogado.getCodigoColegiado());
            abogadoDto.setNombre(abogado.getNombre());
            abogadoDto.setApellidoUno(abogado.getApellidoUno());
            abogadoDto.setApellidoDos(abogado.getApellidoDos());
            return new ResponseEntity<>(abogadoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
