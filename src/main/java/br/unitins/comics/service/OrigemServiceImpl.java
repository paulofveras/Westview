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
    public void create(OrigemDTO dto) {
        Origem origem = new Origem();
        origem.setPais(dto.pais());
        origemRepository.persist(origem);
    }

    @Override
    @Transactional
    public void update(Long id, OrigemDTO dto) {
        Origem origem = origemRepository.findById(id);
        if (origem != null) {
            origem.setPais(dto.pais());
            origemRepository.persist(origem);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Origem origem = origemRepository.findById(id);
        if (origem != null) {
            origemRepository.delete(origem);
        }
    }

    @Override
    public OrigemResponseDTO findById(Long id) {
        Origem origem = origemRepository.findById(id);
        return OrigemResponseDTO.valueOf(origem);
    }

    @Override
    public List<OrigemResponseDTO> findAll() {
        List<Origem> origens = origemRepository.listAll();
        return origens.stream()
            .map(OrigemResponseDTO::valueOf)
            .toList();
    }
}