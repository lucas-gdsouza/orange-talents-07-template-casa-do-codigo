package br.com.zupacademy.cdc.domains;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @ManyToOne
    @NotNull
    @Valid
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'nome' inválido.");
        }

        if (pais == null) {
            throw new IllegalArgumentException("Argumento 'pais' inválido.");
        }

        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}