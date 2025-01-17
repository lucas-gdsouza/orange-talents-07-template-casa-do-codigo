package br.com.zupacademy.cdc.repositories;

import br.com.zupacademy.cdc.domains.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {
}