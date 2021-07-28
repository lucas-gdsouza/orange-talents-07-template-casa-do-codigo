package br.com.zupacademy.cdc.request;

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

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converterParaAutor() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}