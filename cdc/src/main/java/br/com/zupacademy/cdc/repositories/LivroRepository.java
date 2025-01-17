package br.com.zupacademy.cdc.repositories;

import br.com.zupacademy.cdc.domains.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
}