package br.com.zupacademy.cdc.dto;

import br.com.zupacademy.cdc.models.Autor;

import java.time.LocalDateTime;

public class AutorDTO {
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime instante;

    public AutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.instante = autor.getInstante();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }
}