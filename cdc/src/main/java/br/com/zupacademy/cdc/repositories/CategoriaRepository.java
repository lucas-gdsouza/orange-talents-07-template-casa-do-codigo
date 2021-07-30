package br.com.zupacademy.cdc.repositories;

import br.com.zupacademy.cdc.models.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}