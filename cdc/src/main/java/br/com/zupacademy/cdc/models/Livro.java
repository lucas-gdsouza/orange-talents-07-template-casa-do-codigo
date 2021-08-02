package br.com.zupacademy.cdc.models;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @Min(20)
    @NotNull
    private BigDecimal preco;

    @Min(100)
    @NotNull
    private Integer numeroPaginas;

    @NotBlank
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @ManyToOne
    @NotNull
    @Valid
    private Categoria categoria;

    @ManyToOne
    @NotNull
    @Valid
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
                 @Min(20) @NotNull BigDecimal preco, @Min(100) @NotNull Integer numeroPaginas, @NotBlank String isbn,
                 @Future LocalDate dataPublicacao, @NotNull @Valid Categoria categoria,
                 @NotNull @Valid Autor autor) {

        if (titulo == null || titulo.trim().equals("")) {
            throw new IllegalArgumentException("Livro deve ter um título.");
        }

        if (resumo == null || resumo.trim().equals("")) {
            throw new IllegalArgumentException("Livro deve ter um resumo.");
        }

        if (sumario == null || sumario.trim().equals("")) {
            throw new IllegalArgumentException("Livro deve ter um sumário.");
        }

        if (preco == null || preco.compareTo(BigDecimal.valueOf(20.00)) == -1) {
            throw new IllegalArgumentException("O livro deve ter um custo minímo de R$20,00");
        }

        if (numeroPaginas == null || numeroPaginas < 100) {
            throw new IllegalArgumentException("O livro deve ter no minímo 100 páginas.");
        }

        if (isbn == null || isbn.trim().equals("")) {
            throw new IllegalArgumentException("O livro deve ter um ISBN.");
        }

        if (dataPublicacao == null || dataPublicacao.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("O livro deve ser publicado em data superior ao dia atual.");
        }

        if (categoria == null) {
            throw new IllegalArgumentException("O livro deve ter uma categoria.");
        }

        if (autor == null) {
            throw new IllegalArgumentException("O livro deve ter um(a) autor(a).");
        }

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}