package br.com.zupacademy.cdc.requests;

import br.com.zupacademy.cdc.models.Categoria;
import br.com.zupacademy.cdc.validations.annotations.GenericUniqueElement;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @GenericUniqueElement(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converterParaCategoria() {
        return new Categoria(this.nome);
    }
}