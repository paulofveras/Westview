package br.unitins.comics.repository;

import java.util.List;

import br.unitins.comics.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public List<Cliente> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }
    
    public Cliente findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }

    public Cliente findByUsernameAndSenha(String username, String senha) {
        return find("usuario.username = ?1 AND usuario.senha = ?2", username, senha).firstResult();
    }

    public Cliente findByUsername(String username) {

        if (username == null){
            return null;
        }
        return find("usuario.username", username).firstResult();
    }

}
