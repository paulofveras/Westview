package br.unitins.comics.model;


import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)

public enum Material {
    CAPA_DURA(1, "Capa Dura"),
    CAPA_CARTAO(2, "Capa Cartao"),
    PAPEL_JORNAL(3, "Papel Jornal"),
    COUCHE(4, "Papel Couchê");

    private Integer id;
    private String nome;

    Material(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Material valueOf(Integer id) throws IllegalArgumentException {
        for (Material material : Material.values()) {
            if (material.id == id)
                return material;
        }
        throw new IllegalArgumentException("id material inválido.");
    }

}
