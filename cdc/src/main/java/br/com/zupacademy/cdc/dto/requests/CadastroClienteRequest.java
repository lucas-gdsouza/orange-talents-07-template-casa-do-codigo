package br.com.zupacademy.cdc.dto.requests;

import br.com.zupacademy.cdc.domains.Cliente;
import br.com.zupacademy.cdc.domains.Estado;
import br.com.zupacademy.cdc.domains.Pais;
import br.com.zupacademy.cdc.repositories.EstadoRepository;
import br.com.zupacademy.cdc.repositories.PaisRepository;
import br.com.zupacademy.cdc.validations.annotations.GenericUniqueElement;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class CadastroClienteRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @GenericUniqueElement(domainClass = Cliente.class, fieldName = "documento")
    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private Long idPais;

    @NotNull
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public CadastroClienteRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
                                  @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                                  @NotBlank String cidade, @NotNull Long idPais, @NotNull Long idEstado,
                                  @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente converterParaCliente(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Optional<Pais> pais = paisRepository.findById(this.idPais);
        Optional<Estado> estado = estadoRepository.findById(this.idEstado);

        if(!validarRelacionamentoEstadoPais(pais, estado)){
            throw new ResponseStatusException(BAD_REQUEST);
        }

        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento,
                this.cidade, pais.get(), estado.orElse(null), this.telefone, this.cep);
    }

    private boolean validarRelacionamentoEstadoPais(Optional<Pais> pais, Optional<Estado> estado){

        if(pais.isEmpty()){
            return false;
        }

        if(pais.isPresent() && estado.isEmpty()){
            return true;
        }

        return pais.get().getNome().equalsIgnoreCase(estado.get().getPais().getNome());
    }
}