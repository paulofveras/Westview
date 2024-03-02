package br.unitins.comics.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Produto extends PanacheEntity {
    private Long id;
    private String nome;
    private Date dataPublicacao;
    private String edicao;
    private String escritor;
    private String artistaCapa;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;

    public Produto () {
        
    }
    
    public Produto(Long id, String nome, Date dataPublicacao, String edicao, String escritor, String artistaCapa,
            String descricao, double preco, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.dataPublicacao = dataPublicacao;
        this.edicao = edicao;
        this.escritor = escritor;
        this.artistaCapa = artistaCapa;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Produto findById(Long id) {
        return find("id", id).firstResult();
    }

    public static List<Produto> findAllProdutos() {
        return listAll().stream().map(p -> (Produto) p).collect(Collectors.toList());
    }

    public void alterar() {
        persistAndFlush();
    }

    public void excluir() {
        delete();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((dataPublicacao == null) ? 0 : dataPublicacao.hashCode());
        result = prime * result + ((edicao == null) ? 0 : edicao.hashCode());
        result = prime * result + ((escritor == null) ? 0 : escritor.hashCode());
        result = prime * result + ((artistaCapa == null) ? 0 : artistaCapa.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        long temp;
        temp = Double.doubleToLongBits(preco);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + quantidadeEstoque;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (dataPublicacao == null) {
            if (other.dataPublicacao != null)
                return false;
        } else if (!dataPublicacao.equals(other.dataPublicacao))
            return false;
        if (edicao == null) {
            if (other.edicao != null)
                return false;
        } else if (!edicao.equals(other.edicao))
            return false;
        if (escritor == null) {
            if (other.escritor != null)
                return false;
        } else if (!escritor.equals(other.escritor))
            return false;
        if (artistaCapa == null) {
            if (other.artistaCapa != null)
                return false;
        } else if (!artistaCapa.equals(other.artistaCapa))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
            return false;
        if (quantidadeEstoque != other.quantidadeEstoque)
            return false;
        return true;
    }

    
}

