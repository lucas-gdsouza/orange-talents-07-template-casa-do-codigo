package br.com.zupacademy.cdc.domains;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    private LocalDateTime instante = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'nome' inválido.");
        }

        if (email == null || email.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'e-mail' inválido.");
        }

        if (descricao == null || descricao.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'descricao' inválido.");
        }

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}