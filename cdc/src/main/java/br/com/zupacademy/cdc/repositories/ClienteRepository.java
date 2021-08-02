package br.com.zupacademy.cdc.repositories;

import br.com.zupacademy.cdc.domains.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}