package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.OrigemDTO;
import br.unitins.comics.dto.OrigemResponseDTO;
import br.unitins.comics.model.Origem;
import br.unitins.comics.repository.OrigemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrigemServiceImpl implements OrigemService {

    @Inject
    private OrigemRepository origemRepository;

    @Override
    @Transactional
    public OrigemResponseDTO create(OrigemDTO dto) {
        Origem origem = new Origem();
        origem.setPais(dto.pais());
        origemRepository.persist(origem);
        return OrigemResponseDTO.valueOf(origem);
    }

    @Override
    @Transactional
    public void update(Long id, OrigemDTO dto) {
        Origem origemBanco = origemRepository.findById(id);

        origemBanco.setPais(dto.pais());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        origemRepository.deleteById(id);
    }

    @Override
    public OrigemResponseDTO findById(Long id) {
        return OrigemResponseDTO.valueOf(origemRepository.findById(id));
    }


    @Override
    public List<OrigemResponseDTO> findAll() {
        return origemRepository.listAll().stream().map(origens -> OrigemResponseDTO.valueOf(origens)).toList();
    
}
}