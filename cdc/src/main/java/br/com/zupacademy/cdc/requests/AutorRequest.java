package br.com.zupacademy.cdc.requests;

import br.com.zupacademy.cdc.models.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequest(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
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