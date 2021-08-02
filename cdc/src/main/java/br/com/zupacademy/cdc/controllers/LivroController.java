package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.models.Livro;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import br.com.zupacademy.cdc.repositories.CategoriaRepository;
import br.com.zupacademy.cdc.repositories.LivroRepository;
import br.com.zupacademy.cdc.dto.requests.CadastroLivroRequest;
import br.com.zupacademy.cdc.dto.responses.DetalharLivroResponse;
import br.com.zupacademy.cdc.dto.responses.ListarLivroResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

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
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroLivroRequest request) {
        Livro livro = request.converterParaLivro(categoriaRepository, autorRepository);
        livroRepository.save(livro);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    @ResponseBody
    public List<ListarLivroResponse> listar() {
        List<Livro> livroList = (List<Livro>) livroRepository.findAll();
        List<ListarLivroResponse> livroResponseList = new ArrayList();

        for (Livro l : livroList) {
            ListarLivroResponse livroResponse = new ListarLivroResponse(l);
            livroResponseList.add(livroResponse);
        }

        return livroResponseList;
    }

    @GetMapping(value = "/visualizar/{id}")
    @ResponseBody
    public DetalharLivroResponse detalharLivro(@PathVariable("id") Long id) {
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) {
            throw new ResponseStatusException(BAD_REQUEST);
        }

        DetalharLivroResponse detalharLivroResponse = new DetalharLivroResponse(livro.get());

        return detalharLivroResponse;
    }
}