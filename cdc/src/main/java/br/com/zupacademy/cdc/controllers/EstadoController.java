package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.dto.requests.CadastroEstadoRequest;
import br.com.zupacademy.cdc.models.Estado;
import br.com.zupacademy.cdc.models.Pais;
import br.com.zupacademy.cdc.repositories.EstadoRepository;
import br.com.zupacademy.cdc.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroEstadoRequest request){

        Optional<Pais> pais = paisRepository.findById(request.getIdPais());
        Optional<Estado> estado = estadoRepository.findByNomeAndPaisId(request.getNome(),request.getIdPais());

        if(pais.isEmpty() || estado.isPresent()){
            throw new ResponseStatusException(BAD_REQUEST);
        }

        Estado novoEstado = request.converterParaEstado(pais.get());
        estadoRepository.save(novoEstado);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}