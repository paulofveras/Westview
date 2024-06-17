package br.unitins.comics.model.converterjpa;

import br.unitins.comics.model.Material;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MaterialConverter implements AttributeConverter<Material, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Material material) {
       return material.getId();
    }

    @Override
    public Material convertToEntityAttribute(Integer id) {
        return Material.valueOf(id);
    }

    
}