package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.models.Livro;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import br.com.zupacademy.cdc.repositories.CategoriaRepository;
import br.com.zupacademy.cdc.repositories.LivroRepository;
import br.com.zupacademy.cdc.requests.LivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid LivroRequest request) {
        Livro livro = request.converterParaLivro(categoriaRepository, autorRepository);
        livroRepository.save(livro);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
