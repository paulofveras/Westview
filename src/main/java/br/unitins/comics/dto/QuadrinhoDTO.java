package br.unitins.comics.dto;

<<<<<<< HEAD
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
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record QuadrinhoDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String nome, 
    @NotBlank(message = "A descrição não pode ser nula ou vazio")
    String descricao, 
    float preco, 
    Integer quantPaginas, 
    Integer id_material, 
    Long id_fornecedor,
    Integer estoque) { }
>>>>>>> ee80e95e1f4b3b188d07fdf23b8684f8dd807b6e
