package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.FuncionarioDTO;
import br.unitins.comics.dto.FuncionarioResponseDTO;
import br.unitins.comics.dto.PessoaResponseDTO;
import br.unitins.comics.model.Funcionario;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.repository.FuncionarioRepository;
import br.unitins.comics.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import br.unitins.comics.validation.ValidationException;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {
    
    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto){
        validarCpfFuncionario(dto.cpf());
        
         // Criar uma instância de Usuario com os dados do FuncionarioDTO
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setCpf(dto.cpf());


        // Persistir o Usuario no banco de dados antes de associá-lo ao Funcionario
        pessoaRepository.persist(pessoa);

        // Criar uma instância de Funcionario com os dados do FuncionarioDTO
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(dto.cargo());

        // Persistir o Funcionario no banco de dados
        funcionarioRepository.persist(funcionario);

        // Retornar uma representação do funcionário criado
        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    public void validarCpfFuncionario(String cpf){
        Pessoa funcionario = pessoaRepository.findByCpfPessoa(cpf);
        if (funcionario != null)
        throw  new ValidationException("cpf", "O  CPF: '"+ cpf +"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto){
        Funcionario funcionarioBanco = funcionarioRepository.findById(id);
        funcionarioBanco.setCargo(dto.cargo());

         // Criar uma instância de Usuario com os dados do FuncionarioDTO
        Pessoa pessoa =  funcionarioBanco.getPessoa();
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setCpf(dto.cpf());
    }

    @Override
    @Transactional
    public void delete(Long id){
        funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioResponseDTO findById(Long id){
        return FuncionarioResponseDTO.valueOf(funcionarioRepository.findById(id));
    }

    @GET
    public List<FuncionarioResponseDTO> findAll(){
        return funcionarioRepository.listAll().stream().map(a -> FuncionarioResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<FuncionarioResponseDTO> findByCargo(String cargo) {
        return funcionarioRepository.findByCargo(cargo).stream().map(funcionario -> FuncionarioResponseDTO.valueOf(funcionario)).toList();
    }
    
    @Override
    public List<PessoaResponseDTO> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).stream().map(c -> PessoaResponseDTO.valueOf(c)).toList();
    }
}
