package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.validations.binders.ValidarEmail;
import br.com.zupacademy.cdc.models.Autor;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import br.com.zupacademy.cdc.requests.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    /*@Autowired
    private ValidarEmail validarEmail;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validarEmail);
    }*/

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid AutorRequest request) {
        Autor autor = request.converterParaAutor();
        autorRepository.save(autor);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}