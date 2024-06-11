package br.unitins.comics.repository;

import java.util.List;

import br.unitins.comics.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
    public List<Usuario> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Usuario> findByCpf(String cpf){
        return find("cpf LIKE ?1", "%" + cpf + "%").list();
    }

    public Usuario findByCpfUsuario(String cpf){
        return find("cpf LIKE ?1", "%" + cpf + "%").firstResult();
    }
}
