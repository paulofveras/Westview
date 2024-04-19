package br.unitins.comics.model;

import java.time.LocalDate;
import java.util.List;
import br.unitins.comics.dto.PessoaDTO;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Quadrinho extends DefaultEntity {

    private String nome;
    private LocalDate dataPublicacao;
    private String edicao;
    private Double preco;
    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ElementCollection
    private List<String> personagens;

    @ManyToOne
    @JoinColumn(name = "id_escritor")
    private Pessoa escritor;

    @ManyToOne
    @JoinColumn(name = "id_artista_capa")
    private Pessoa artistaCapa;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Origem origem;

    public Quadrinho(String nome, LocalDate dataPublicacao, String edicao, Double preco, Integer quantidadeEstoque,
            Categoria categoria, List<String> personagens, Pessoa escritor, Pessoa artistaCapa,
            Classificacao classificacao, Genero genero, Origem origem) {
        this.nome = nome;
        this.dataPublicacao = dataPublicacao;
        this.edicao = edicao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.personagens = personagens;
        this.escritor = escritor;
        this.artistaCapa = artistaCapa;
        this.classificacao = classificacao;
        this.genero = genero;
        this.origem = origem;
    }

    public Quadrinho() {
        //TODO Auto-generated constructor stub
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
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

