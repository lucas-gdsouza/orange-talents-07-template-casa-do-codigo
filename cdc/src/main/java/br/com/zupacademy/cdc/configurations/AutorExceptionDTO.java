package br.com.zupacademy.cdc.configurations;

public class AutorExceptionDTO {
    public String nome;
    public String tipo;

    public AutorExceptionDTO(String nome, String tipo) {
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