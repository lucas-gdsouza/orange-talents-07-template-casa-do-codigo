package br.com.zupacademy.cdc.dto.requests;

import br.com.zupacademy.cdc.domains.Autor;
import br.com.zupacademy.cdc.validations.annotations.GenericUniqueElement;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastroAutorRequest {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    @GenericUniqueElement(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public CadastroAutorRequest(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400)
            String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return this.email;
    }

    public Autor converterParaAutor() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}