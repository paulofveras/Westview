package br.unitins.comics.repository;

import br.unitins.comics.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {

    public Endereco findByCEP(Integer cep) {
        return find("cep = ?1", cep).firstResult();
    }
    
}
