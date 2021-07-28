package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.models.Autor;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import br.com.zupacademy.cdc.request.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.converterParaAutor();
        autorRepository.save(autor);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}