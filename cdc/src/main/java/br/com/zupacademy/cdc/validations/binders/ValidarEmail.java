package br.com.zupacademy.cdc.validations.binders;


import br.com.zupacademy.cdc.models.Autor;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import br.com.zupacademy.cdc.dto.requests.CadastroAutorRequest;
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
        return CadastroAutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CadastroAutorRequest request = (CadastroAutorRequest) o;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());

        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null, "O e-mail já está cadastrado.");
        }
    }
}