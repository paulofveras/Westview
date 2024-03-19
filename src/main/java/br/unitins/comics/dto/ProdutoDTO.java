package br.unitins.comics.dto;

import java.time.LocalDate;

import br.unitins.comics.model.EditoraEnum;
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
    private EditoraEnum editora;
    
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

    public EditoraEnum getEditora() {
        return editora;
    }

    public void setEditora(EditoraEnum editora) {
        this.editora = editora;
    }

    public ProdutoDTO(@NotBlank(message = "O nome do produto é obrigatório") String nome,
            @NotNull(message = "A data de publicação é obrigatória") LocalDate dataPublicacao, String edicao,
            String escritor, String artistaCapa, String descricao, double preco, int quantidadeEstoque,
            EditoraEnum editora) {
        this.nome = nome;
        this.dataPublicacao = dataPublicacao;
        this.edicao = edicao;
        this.escritor = escritor;
        this.artistaCapa = artistaCapa;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "ProdutoDTO [nome=" + nome + ", dataPublicacao=" + dataPublicacao + ", edicao=" + edicao + ", escritor="
                + escritor + ", artistaCapa=" + artistaCapa + ", descricao=" + descricao + ", preco=" + preco
                + ", quantidadeEstoque=" + quantidadeEstoque + ", editora=" + editora + "]";
    }

    
    
    
}

