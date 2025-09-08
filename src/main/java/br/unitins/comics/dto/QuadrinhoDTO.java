package br.unitins.comics.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.comics.model.Categoria;

public record QuadrinhoDTO (
    String nome,
    LocalDate dataPublicacao,
    String edicao,
    String descricao,
    double preco,
    int quantidadeEstoque,
    Categoria categoria,
    List<String> personagens,
    PessoaDTO escritor,
    PessoaDTO artistaCapa
) {

    public String getNome() {
        return nome;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<String> getPersonagens() {
        return personagens;
    }

    public PessoaDTO getEscritor() {
        return escritor;
    }

    public PessoaDTO getArtistaCapa() {
        return artistaCapa;
    } 
    
}   