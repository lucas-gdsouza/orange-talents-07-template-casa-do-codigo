package br.com.zupacademy.cdc.dto.responses;

import br.com.zupacademy.cdc.domains.Autor;

public class DetalharAutorResponse {

    private String nome;
    private String descricao;

    public DetalharAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}