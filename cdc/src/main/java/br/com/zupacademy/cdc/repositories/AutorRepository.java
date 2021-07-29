package br.com.zupacademy.cdc.repositories;

import br.com.zupacademy.cdc.models.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
}
