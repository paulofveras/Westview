package br.unitins.comics.repository;

import java.util.List;

import br.unitins.comics.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {

    public List<Pessoa> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }

    public List<Pessoa> findByCpf(String cpf) {
        return find("cpf = ?1", cpf).list();
    }

    // Outros métodos de busca, se necessário
}
