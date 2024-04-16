package br.unitins.comics.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.comics.dto.PessoaDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Quadrinho extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataPublicacao;
    private String edicao;
    private double preco;
    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToMany
    private List<String> personagens;

    @OneToOne
    @JoinColumn(name = "id_escritor")
    private Pessoa escritor;

    @OneToOne
    @JoinColumn(name = "id_artista_capa")
    private Pessoa artistaCapa;

    @ManyToOne
    @JoinColumn(name = "id_classificacao")
    private Classificacao classificacao;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Origem origem;

    public static Quadrinho findById(Long id) {
        return find("id", id).firstResult();
    }

    public static List<Quadrinho> findAllQuadrinhos() {
        return listAll().stream().map(p -> (Quadrinho) p).collect(Collectors.toList());
    }

    public void alterar() {
        persistAndFlush();
    }

    public void excluir() {
        delete();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public Pessoa getEscritor() {
        return escritor;
    }

    public void setEscritor(Pessoa escritor) {
        this.escritor = escritor;
    }

    public Pessoa getArtistaCapa() {
        return artistaCapa;
    }

    public void setArtistaCapa(Pessoa artistaCapa) {
        this.artistaCapa = artistaCapa;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public void setEscritor(PessoaDTO escritor2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEscritor'");
    }

    public void setArtistaCapa(PessoaDTO artistaCapa2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setArtistaCapa'");
    }

    public void setDescricao(Object descricao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDescricao'");
    }
 
    
}

