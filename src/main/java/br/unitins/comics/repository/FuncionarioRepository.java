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

}