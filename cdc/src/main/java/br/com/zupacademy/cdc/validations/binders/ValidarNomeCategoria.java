package br.com.zupacademy.cdc.validations.binders;

import br.com.zupacademy.cdc.models.Categoria;
import br.com.zupacademy.cdc.repositories.CategoriaRepository;
import br.com.zupacademy.cdc.requests.CadastroCategoriaRequest;
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
        return CadastroCategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CadastroCategoriaRequest request = (CadastroCategoriaRequest) o;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());

        if (possivelCategoria.isPresent()) {
            errors.rejectValue("nome", null, "O nome da categoria já está cadastrado");
        }
    }
}