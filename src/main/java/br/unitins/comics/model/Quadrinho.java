package br.unitins.comics.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Quadrinho extends DefaultEntity {

    @Column(length = 60, nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    private String edicao;

    @Column(nullable = false)
    private Double preco;

    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_escritor")
    private Escritor escritor;

    @ManyToOne
    @JoinColumn(name="id_artista_capa")
    private ArtistaCapa artistaCapa;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id_origem", nullable = false)
    private Origem origem;

    private String nomeImagem;

    private Integer estoque;

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

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

    public ArtistaCapa getArtistaCapa() {
        return artistaCapa;
    }

    public void setArtistaCapa(ArtistaCapa artistaCapa) {
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

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
 
}

