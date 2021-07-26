package br.com.zupacademy.cdc.controllers;

import br.com.zupacademy.cdc.dto.AutorDTO;
import br.com.zupacademy.cdc.form.AutorForm;
import br.com.zupacademy.cdc.models.Autor;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorDTO> cadastrar(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = AutorForm.Converter(autorForm);
        autorRepository.save(autor);

        URI uri = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new AutorDTO(autor));
    }
}