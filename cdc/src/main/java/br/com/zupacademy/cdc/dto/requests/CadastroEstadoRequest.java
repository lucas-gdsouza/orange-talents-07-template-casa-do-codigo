package br.com.zupacademy.cdc.dto.requests;

import br.com.zupacademy.cdc.models.Estado;
import br.com.zupacademy.cdc.models.Pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastroEstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    private Long idPais;

    public CadastroEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }
    public Long getIdPais() {
        return idPais;
    }

    public String getNome() {
        return nome;
    }

    public Estado converterParaEstado(Pais pais){
        return new Estado(this.nome, pais);
    }
}