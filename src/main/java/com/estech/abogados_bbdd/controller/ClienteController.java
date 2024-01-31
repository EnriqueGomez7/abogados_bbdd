package com.estech.abogados_bbdd.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estech.abogados_bbdd.DTO.ClienteDTO;
import com.estech.abogados_bbdd.model.Abogado;
import com.estech.abogados_bbdd.model.Cliente;
import com.estech.abogados_bbdd.repository.AbogadoRepository;
import com.estech.abogados_bbdd.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private AbogadoRepository abogadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/cliente")
    public ResponseEntity<Map<String, Object>> agregarCliente(@RequestBody ClienteDTO clienteDto) {
        Abogado abogado = abogadoRepository.findById(clienteDto.getAbogado().getCodigoColegiado()).orElse(null);

        if (abogado != null) {
            Cliente cliente = new Cliente();
            cliente.setNombreCliente(clienteDto.getNombreCliente());
            cliente.setApellidoCliente(clienteDto.getApellidoCliente());
            cliente.setAbogado(abogado);
            clienteRepository.save(cliente);

            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("idabogado", abogado.getCodigoColegiado());
            respuesta.put("idCliente", cliente.getId());

            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
