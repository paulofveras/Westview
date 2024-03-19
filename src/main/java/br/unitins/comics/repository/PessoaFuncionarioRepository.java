package br.unitins.comics.repository;

import br.unitins.comics.model.PessoaFuncionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaFuncionarioRepository implements PanacheRepository<PessoaFuncionario>{
    
}
