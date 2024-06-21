package br.unitins.comics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Quadrinho extends DefaultEntity {

    private String nome;
    private String descricao;
    private float preco;
    private Integer quantPaginas;
    private Material material;
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;
    private String nomeImagem;
    private Integer estoque;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public Integer getQuantPaginas() {
        return quantPaginas;
    }
    public void setQuantPaginas(Integer quantPaginas) {
        this.quantPaginas = quantPaginas;
    }
    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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