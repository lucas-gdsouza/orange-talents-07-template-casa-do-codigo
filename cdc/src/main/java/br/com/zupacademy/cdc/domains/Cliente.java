package br.com.zupacademy.cdc.domains;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    /*
    * O documento pode ser um CPF ou CNPJ
     */

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @ManyToOne
    @NotNull
    @Valid
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Deprecated
    public Cliente() {
    }

    public Cliente(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
                   @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                   @NotBlank String cidade, @NotNull Pais pais, @NotNull Estado estado,
                   @NotBlank String telefone, @NotBlank String cep) {

        if (email == null || email.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'email' inválido.");
        }

        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'nome' inválido.");
        }

        if (sobrenome == null || sobrenome.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'sobrenome' inválido.");
        }

        if (documento == null || documento.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'documento' inválido.");
        }

        if (endereco == null || endereco.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'endereco' inválido.");
        }

        if (complemento == null || complemento.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'complemento' inválido.");
        }

        if (cidade == null) {
            throw new IllegalArgumentException("Argumento 'cidade' inválido.");
        }

        if (pais == null) {
            throw new IllegalArgumentException("Argumento 'pais' inválido.");
        }

        if (telefone == null || telefone.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'telefone' inválido.");
        }

        if (cep == null || cep.trim().equals("")) {
            throw new IllegalArgumentException("Argumento 'CEP' inválido.");
        }

        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }
}