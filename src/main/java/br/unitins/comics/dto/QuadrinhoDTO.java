package br.unitins.comics.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.comics.model.Classificacao;

public class QuadrinhoDTO {
    private String nome;
    private LocalDate dataPublicacao;
    private String edicao;
    private double preco;
    private Integer quantidadeEstoque;
    private CategoriaDTO categoria;
    private List<String> personagens;
    private PessoaDTO escritor;
    private PessoaDTO artistaCapa;
    private Classificacao classificacao;
    private GeneroDTO genero;
    private OrigemDTO origem;
    
    public QuadrinhoDTO() {
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

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<String> personagens) {
        this.personagens = personagens;
    }

    public PessoaDTO getEscritor() {
        return escritor;
    }

    public void setEscritor(PessoaDTO escritor) {
        this.escritor = escritor;
    }

    public PessoaDTO getArtistaCapa() {
        return artistaCapa;
    }

    public void setArtistaCapa(PessoaDTO artistaCapa) {
        this.artistaCapa = artistaCapa;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public GeneroDTO getGenero() {
        return genero;
    }

    public void setGenero(GeneroDTO genero) {
        this.genero = genero;
    }

    public OrigemDTO getOrigem() {
        return origem;
    }

    public void setOrigem(OrigemDTO origem) {
        this.origem = origem;
    }

    public Object getDescricao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescricao'");
    }

    public Long getCategoriaId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoriaId'");
    }

    
}

