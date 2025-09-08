package br.unitins.comics.repository;

import br.unitins.comics.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistaCapaRepository implements PanacheRepository<Pessoa> {
    // Implemente os métodos necessários aqui
}