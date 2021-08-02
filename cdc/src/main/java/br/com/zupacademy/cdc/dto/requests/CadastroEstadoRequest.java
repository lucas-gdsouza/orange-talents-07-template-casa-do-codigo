package br.com.zupacademy.cdc.dto.requests;

import br.com.zupacademy.cdc.domains.Estado;
import br.com.zupacademy.cdc.domains.Pais;
import br.com.zupacademy.cdc.repositories.EstadoRepository;
import br.com.zupacademy.cdc.repositories.PaisRepository;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class CadastroEstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    private Long idPais;

    public CadastroEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado converterParaEstado(PaisRepository paisRepository, EstadoRepository estadoRepository){
        Optional<Pais> pais = paisRepository.findById(this.idPais);
        Optional<Estado> estado = estadoRepository.findByNomeAndPaisId(this.nome, this.idPais);

        if(pais.isEmpty() || estado.isPresent()){
            throw new ResponseStatusException(BAD_REQUEST);
        }

        return new Estado(this.nome, pais.get());
    }
}