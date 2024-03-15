package br.unitins.comics.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoDTO {
    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;
    @NotNull(message = "A data de publicação é obrigatória")
    private LocalDate dataPublicacao;
    private String edicao;
    private String escritor;
    private String artistaCapa;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;
    private Long categoriaId;
    
    public ProdutoDTO() {
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

    public Long getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public ProdutoDTO(String nome, LocalDate dataPublicacao, String edicao, String escritor, String artistaCapa,
            String descricao, double preco, int quantidadeEstoque, Long categoriaId) {
        this.nome = nome;
        this.dataPublicacao = dataPublicacao;
        this.edicao = edicao;
        this.escritor = escritor;
        this.artistaCapa = artistaCapa;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoriaId = categoriaId;
    }
    @Override
    public String toString() {
        return "ProdutoDTO [nome=" + nome + ", dataPublicacao=" + dataPublicacao + ", edicao=" + edicao + ", escritor="
                + escritor + ", artistaCapa=" + artistaCapa + ", descricao=" + descricao + ", preco=" + preco
                + ", quantidadeEstoque=" + quantidadeEstoque + ", categoriaId=" + categoriaId + "]";
    }

    
    
}

