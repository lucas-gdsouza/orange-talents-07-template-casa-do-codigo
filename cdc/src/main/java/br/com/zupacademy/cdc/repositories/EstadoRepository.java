package br.com.zupacademy.cdc.repositories;

import br.com.zupacademy.cdc.domains.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {
    Optional<Estado> findByNomeAndPaisId(String nome, Long id);
}