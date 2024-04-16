package br.unitins.comics.repository;

import br.unitins.comics.model.Origem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrigemRepository implements PanacheRepository<Origem>{
    
}
