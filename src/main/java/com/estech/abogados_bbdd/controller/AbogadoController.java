package com.estech.abogados_bbdd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estech.abogados_bbdd.model.Abogado;
import com.estech.abogados_bbdd.model.Cliente;
import com.estech.abogados_bbdd.repository.AbogadoRepository;
import com.estech.abogados_bbdd.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
public class AbogadoController {
    
@Autowired
    private AbogadoRepository abogadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/abogado")
    public ResponseEntity<List<Map<String, Object>>> obtenerAbogadosConClientes() {
        List<Abogado> abogados = abogadoRepository.findAll();

        List<Map<String, Object>> abogadosConClientes = new ArrayList<>();

        for (Abogado abogado : abogados) {
            List<Cliente> clientes = clienteRepository.findByAbogadoCodigoColegiado(abogado.getCodigoColegiado());

            Map<String, Object> abogadoConClientes = new HashMap<>();
            abogadoConClientes.put("codigoColegiado", abogado.getCodigoColegiado());

            List<Map<String, Object>> clientesDto = new ArrayList<>();
            for (Cliente cliente : clientes) {
                Map<String, Object> clienteDto = new HashMap<>();
                clienteDto.put("id", cliente.getId());
                clienteDto.put("nombreCliente", cliente.getNombreCliente());
                clienteDto.put("apellidoCliente", cliente.getApellidoCliente());
                clientesDto.add(clienteDto);
            }

            abogadoConClientes.put("clientes", clientesDto);
            abogadosConClientes.add(abogadoConClientes);
        }

        return new ResponseEntity<>(abogadosConClientes, HttpStatus.OK);
    }

}
