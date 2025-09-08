package br.unitins.comics.repository;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> ee80e95e1f4b3b188d07fdf23b8684f8dd807b6e
import br.unitins.comics.model.Quadrinho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuadrinhoRepository implements PanacheRepository<Quadrinho> {

<<<<<<< HEAD
    public Quadrinho findByNome(String nome) {
        return find("nome", nome).firstResult();
=======
    public List<Quadrinho> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }

    public Quadrinho findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
>>>>>>> ee80e95e1f4b3b188d07fdf23b8684f8dd807b6e
    }
    
}
