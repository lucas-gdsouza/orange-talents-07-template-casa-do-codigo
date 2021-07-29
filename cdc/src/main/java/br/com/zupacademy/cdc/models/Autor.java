package br.com.zupacademy.cdc.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @NotNull
    private LocalDateTime instante = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {

        if (nome == null || descricao.trim().equals("")) {
            throw new IllegalArgumentException("Autor(a) deve ter um nome.");
        }
        this.nome = nome;


        if (email == null || descricao.trim().equals("")) {
            throw new IllegalArgumentException("Autor(a) deve ter um e-mail.");
        }
        this.email = email;

        if (descricao == null || descricao.trim().equals("")) {
            throw new IllegalArgumentException("Autor(a) deve ter uma descrição.");
        }
        this.descricao = descricao;
    }
}