package br.unitins.comics.model;

import java.time.LocalDate;
import java.util.List;

import br.unitins.comics.dto.PessoaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Quadrinho extends DefaultEntity {

    @Column(length = 60, nullable = false)
    private String nome;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dataPublicacao;

    private String edicao;

    @Column(length = 60, nullable = false)
    private Double preco;

    @Column(length = 60)
    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
        name = "quadrinho_escritor",
        joinColumns = @JoinColumn(name = "id_quadrinho"),
        inverseJoinColumns = @JoinColumn(name = "id_escritor") 
    )
    private List<Escritor> listaEscritor;

    @ManyToMany
    @JoinTable(
        name = "quadrinho_artistacapa",
        joinColumns = @JoinColumn(name = "id_quadrinho"),
        inverseJoinColumns = @JoinColumn(name = "id_artista_capa") 
    )
    private List<ArtistaCapa> listaArtistaCapa;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id_origem", nullable = false)
    private Origem origem;

    public Quadrinho() {
    }

    public Quadrinho(String nome, LocalDate dataPublicacao, String edicao, Double preco, Integer quantidadeEstoque,
            Categoria categoria, List<Escritor> listaEscritor, List<ArtistaCapa> listaArtistaCapa, Classificacao classificacao,
            Genero genero, Origem origem) {
        this.nome = nome;
        this.dataPublicacao = dataPublicacao;
        this.edicao = edicao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.listaEscritor = listaEscritor;
        this.listaArtistaCapa = listaArtistaCapa;
        this.classificacao = classificacao;
        this.genero = genero;
        this.origem = origem;
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

    public List<Escritor> getListaEscritor() {
        return listaEscritor;
    }

    public void setListaEscritor(List<Escritor> listaEscritor) {
        this.listaEscritor = listaEscritor;
    }

    public List<ArtistaCapa> getListaArtistaCapa() {
        return listaArtistaCapa;
    }

    public void setListaArtistaCapa(List<ArtistaCapa> listaArtistaCapa) {
        this.listaArtistaCapa = listaArtistaCapa;
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



    
}

