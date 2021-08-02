package br.com.zupacademy.cdc.requests;

import br.com.zupacademy.cdc.models.Autor;
import br.com.zupacademy.cdc.models.Categoria;
import br.com.zupacademy.cdc.models.Livro;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import br.com.zupacademy.cdc.repositories.CategoriaRepository;
import br.com.zupacademy.cdc.validations.annotations.GenericUniqueElement;

import javax.validation.constraints.*;
import java.lang.reflect.InaccessibleObjectException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class LivroRequest {


    @GenericUniqueElement(domainClass = Livro.class, fieldName = "titulo")
    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

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
    private LocalDateTime dataPublicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                        @Min(20) @NotNull BigDecimal preco, @Min(100) @NotNull Integer numeroPaginas,
                        @NotBlank String isbn, @Future LocalDateTime dataPublicacao, @NotNull Long idCategoria,
                        @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro converterParaLivro(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {

        Optional<Categoria> categoria = categoriaRepository.findById(this.idCategoria);
        Optional<Autor> autor = autorRepository.findById(idAutor);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
                this.dataPublicacao, categoria.orElseThrow(() -> new InaccessibleObjectException()),
                autor.orElseThrow(() -> new InaccessibleObjectException()));
    }
}
