package br.com.zupacademy.cdc.components;


import br.com.zupacademy.cdc.models.Autor;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import br.com.zupacademy.cdc.requests.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
public class ValidarEmail implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AutorRequest request = (AutorRequest) o;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());

        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null, "O e-mail já está cadastrado.");
        }
    }
}