package br.com.zupacademy.cdc.dto.requests;

import br.com.zupacademy.cdc.domains.Pais;
import br.com.zupacademy.cdc.validations.annotations.GenericUniqueElement;

import javax.validation.constraints.NotBlank;

public class CadastroPaisRequest {

    @GenericUniqueElement(domainClass = Pais.class, fieldName = "nome")
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais converterParaPais() {
        return new Pais(this.nome);
    }
}