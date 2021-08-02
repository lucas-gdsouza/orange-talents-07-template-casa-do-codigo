package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.models.Livro;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import br.com.zupacademy.cdc.repositories.CategoriaRepository;
import br.com.zupacademy.cdc.repositories.LivroRepository;
import br.com.zupacademy.cdc.requests.LivroRequest;
import br.com.zupacademy.cdc.responses.LivroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    @ResponseBody
    public List<LivroResponse> listar() {
        List<Livro> livroList = (List<Livro>) livroRepository.findAll();
        List<LivroResponse> livroResponseList = new ArrayList();

        for (Livro l : livroList) {
            LivroResponse livroResponse = new LivroResponse(l);
            livroResponseList.add(livroResponse);
        }

        return livroResponseList;
    }
}