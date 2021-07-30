package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.validations.binders.ValidarNomeCategoria;
import br.com.zupacademy.cdc.models.Categoria;
import br.com.zupacademy.cdc.repositories.CategoriaRepository;
import br.com.zupacademy.cdc.requests.CategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    /*@Autowired
    private ValidarNomeCategoria validarNomeCategoria;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validarNomeCategoria);
    }*/

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CategoriaRequest request) {
        Categoria categoria = request.converterParaCategoria();
        categoriaRepository.save(categoria);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}