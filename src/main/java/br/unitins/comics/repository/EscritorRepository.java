package br.unitins.comics.repository;

import java.util.List;

import br.unitins.comics.model.Escritor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EscritorRepository implements PanacheRepository<Escritor>{
    
    public List<Escritor> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() +"%").list();
    }

        public Escritor findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }
}

