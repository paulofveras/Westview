package br.unitins.comics.repository;

import br.unitins.comics.model.Quadrinho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuadrinhoRepository implements PanacheRepository<Quadrinho> {

    public Quadrinho findByNome(String nome) {
        return find("nome", nome).firstResult();
    }
    
}
