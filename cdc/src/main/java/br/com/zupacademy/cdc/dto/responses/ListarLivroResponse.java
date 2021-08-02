package br.com.zupacademy.cdc.dto.responses;

import br.com.zupacademy.cdc.domains.Livro;

public class ListarLivroResponse {

    private Long id;
    private String titulo;

    public ListarLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}