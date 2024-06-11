package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.EscritorDTO;
import br.unitins.comics.dto.EscritorResponseDTO;
import br.unitins.comics.model.Escritor;
import br.unitins.comics.repository.EscritorRepository;
import br.unitins.comics.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class EscritorServiceImpl implements EscritorService {

    @Inject
    public EscritorRepository escritorRepository;

    @Override
    @Transactional
    public EscritorResponseDTO create(@Valid EscritorDTO dto){
        validarNomeCompletoEscritor(dto.nome());

        Escritor escritor = new Escritor();
        escritor.setNome(dto.nome());

        escritorRepository.persist(escritor);
        return EscritorResponseDTO.valueOf(escritor);
    }

    public void validarNomeCompletoEscritor(String nome) {
        Escritor escritor = escritorRepository.findByNomeCompleto(nome);
        if (escritor != null)
            throw  new ValidationException("nome", "O nome '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, EscritorDTO dto){
        Escritor escritorBanco = escritorRepository.findById(id);

        escritorBanco.setNome(dto.nome());
    }

    @Override
    @Transactional
    public void delete(Long id){
        escritorRepository.deleteById(id);
    }

    @Override
    public EscritorResponseDTO findById(Long id){
        return EscritorResponseDTO.valueOf(escritorRepository.findById(id));
    }

    @Override
    public List<EscritorResponseDTO> findAll(){
        return escritorRepository.listAll().stream().map(escritor -> EscritorResponseDTO.valueOf(escritor)).toList();
    }

    @Override
    public List<EscritorResponseDTO> findByNome(String nome){
        return escritorRepository.findByNome(nome).stream().map(escritor -> EscritorResponseDTO.valueOf(escritor)).toList();
    }

}
