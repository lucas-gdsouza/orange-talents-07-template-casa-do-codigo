package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.dto.requests.CadastroClienteRequest;
import br.com.zupacademy.cdc.domains.Cliente;
import br.com.zupacademy.cdc.dto.responses.CadastroClienteResponse;
import br.com.zupacademy.cdc.repositories.ClienteRepository;
import br.com.zupacademy.cdc.repositories.EstadoRepository;
import br.com.zupacademy.cdc.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroClienteRequest request, UriComponentsBuilder uriComponentsBuilder){
        Cliente cliente = request.converterParaCliente(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        CadastroClienteResponse response = new CadastroClienteResponse(cliente.getId());
        URI uri = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.status(HttpStatus.OK).body(uri);
    }
}