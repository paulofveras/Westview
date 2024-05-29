package br.unitins.comics.repository;

import java.util.List;

import br.unitins.comics.model.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario>{
    public List<Funcionario> findByCargo(String cargo){
        return find("UPPER(cargo) LIKE ?1", "%" + cargo.toUpperCase() + "%").list();
    }
    
    public Funcionario findByCargoFuncionario(String cargo){
        return find("UPPER(cargo) LIKE ?1", "%" + cargo.toUpperCase() ).firstResult();
    }

    public Funcionario findByUsernameAndSenha(String username, String senha) {
    return find("pessoa.username = ?1 AND pessoa.senha = ?2", username, senha).firstResult();
    }

    public Funcionario findByCpf(String cpf){
        return find("pessoa.cpf = ?1", cpf).firstResult();
    }

}