package br.com.zupacademy.cdc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Deprecated
    public Categoria(){ }

    public Categoria(String nome) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'nome' inválido.");
        }

        this.nome = nome;
    }
}