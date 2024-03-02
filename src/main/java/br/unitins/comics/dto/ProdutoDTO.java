package br.unitins.comics.dto;

import java.util.Date;

public class ProdutoDTO {
    private String nome;
    private Date dataPublicacao;
    private String edicao;
    private String escritor;
    private String artistaCapa;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    public String getEdicao() {
        return edicao;
    }
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    public String getEscritor() {
        return escritor;
    }
    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }
    public String getArtistaCapa() {
        return artistaCapa;
    }
    public void setArtistaCapa(String artistaCapa) {
        this.artistaCapa = artistaCapa;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    public ProdutoDTO(String nome, Date dataPublicacao, String edicao, String escritor, String artistaCapa,
            String descricao, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.dataPublicacao = dataPublicacao;
        this.edicao = edicao;
        this.escritor = escritor;
        this.artistaCapa = artistaCapa;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    
}

