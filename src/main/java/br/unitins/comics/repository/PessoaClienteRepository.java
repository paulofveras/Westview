package br.unitins.comics.repository;

import br.unitins.comics.model.PessoaCliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaClienteRepository implements PanacheRepository<PessoaCliente> {
    
}
