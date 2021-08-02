package br.com.zupacademy.cdc.requests;

import br.com.zupacademy.cdc.models.Autor;
import br.com.zupacademy.cdc.models.Categoria;
import br.com.zupacademy.cdc.models.Livro;
import br.com.zupacademy.cdc.repositories.AutorRepository;
import br.com.zupacademy.cdc.repositories.CategoriaRepository;
import br.com.zupacademy.cdc.validations.annotations.GenericUniqueElement;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class CadastroLivroRequest {
    @GenericUniqueElement(domainClass = Livro.class, fieldName = "titulo")
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

    @GenericUniqueElement(domainClass = Livro.class, fieldName = "isbn")
    @NotBlank
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;

    public CadastroLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
                                @Min(20) @NotNull BigDecimal preco, @Min(100) @NotNull Integer numeroPaginas,
                                @NotBlank String isbn, @NotNull Long idCategoria,
                                @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    /* Setter criado porque o Jackson não compreendeu a validação @JsonFormat via Construtor */
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro converterParaLivro(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {

        Optional<Categoria> categoria = categoriaRepository.findById(this.idCategoria);
        Optional<Autor> autor = autorRepository.findById(idAutor);

        if (categoria.isEmpty() || autor.isEmpty()) {
            throw new ResponseStatusException(BAD_REQUEST);
        }

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
                this.dataPublicacao, categoria.get(), autor.get());
    }
}