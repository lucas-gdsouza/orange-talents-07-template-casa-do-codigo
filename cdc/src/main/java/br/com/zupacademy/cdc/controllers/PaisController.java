package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.dto.requests.CadastroPaisRequest;
import br.com.zupacademy.cdc.models.Pais;
import br.com.zupacademy.cdc.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroPaisRequest request) {
        Pais pais = request.converterParaPais();
        paisRepository.save(pais);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}