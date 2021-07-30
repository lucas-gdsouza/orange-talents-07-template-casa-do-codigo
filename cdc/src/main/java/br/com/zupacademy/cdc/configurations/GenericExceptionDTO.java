package br.com.zupacademy.cdc.configurations;

public class GenericExceptionDTO {
    public String nome;
    public String tipo;

    public GenericExceptionDTO(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}