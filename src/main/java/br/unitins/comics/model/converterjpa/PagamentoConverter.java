package br.unitins.comics.model.converterjpa;

import br.unitins.comics.model.Pagamento;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PagamentoConverter implements AttributeConverter<Pagamento, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Pagamento pagamento) {
       return pagamento.getId();
    }

    @Override
    public Pagamento convertToEntityAttribute(Integer id) {
        return Pagamento.valueOf(id);
    }

    
}