package br.unitins.comics.repository;

import java.util.List;

import br.unitins.comics.model.ArtistaCapa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistaCapaRepository implements PanacheRepository<ArtistaCapa>{
    
    public List<ArtistaCapa> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }

}
