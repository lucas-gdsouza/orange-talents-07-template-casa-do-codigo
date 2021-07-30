package br.com.zupacademy.cdc.components;

import br.com.zupacademy.cdc.models.Categoria;
import br.com.zupacademy.cdc.repositories.CategoriaRepository;
import br.com.zupacademy.cdc.requests.CategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidarNomeCategoria implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CategoriaRequest request = (CategoriaRequest) o;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());

        if (possivelCategoria.isPresent()) {
            errors.rejectValue("nome", null, "O nome da categoria já está cadastrado");
        }
    }
}