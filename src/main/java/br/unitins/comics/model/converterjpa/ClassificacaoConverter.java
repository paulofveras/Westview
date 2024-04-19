package br.unitins.comics.model.converterjpa;

import br.unitins.comics.model.Classificacao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ClassificacaoConverter implements AttributeConverter<Classificacao, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Classificacao classificacao) {
        return classificacao.getId();
    }

    @Override
    public Classificacao convertToEntityAttribute(Integer id) {
        // Implemente a lógica para converter o id em uma instância de Classificacao
        switch (id) {
            case 1:
                return Classificacao.LIVRE;
            case 2:
                return Classificacao.DEZANOS;
            case 3:
                return Classificacao.DOZEANOS;
            case 4:
                return Classificacao.QUATORZEANOS;
            case 5:
                return Classificacao.DEZESSEISANOS;
            case 6:
                return Classificacao.DEZOITOANOS;
            default:
                throw new IllegalArgumentException("id classificacao inválido: " + id);
        }
    }
}