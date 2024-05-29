package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ClienteDTO;
import br.unitins.comics.dto.ClienteResponseDTO;
import br.unitins.comics.dto.PessoaResponseDTO;
import br.unitins.comics.model.Cliente;
import br.unitins.comics.model.Funcionario;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.repository.ClienteRepository;
import br.unitins.comics.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import br.unitins.comics.validation.ValidationException;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {
    
    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public ClienteResponseDTO create(ClienteDTO dto){
        validarCpfCliente(dto.cpf());
        
         // Criar uma instância de Usuario com os dados do ClienteDTO
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setCpf(dto.cpf());


        // Persistir o Usuario no banco de dados antes de associá-lo ao Cliente
        pessoaRepository.persist(pessoa);

        // Criar uma instância de Cliente com os dados do ClienteDTO
        Cliente cliente = new Cliente();
        cliente.setCidade(dto.cidade());
        cliente.setEstado(dto.estado());

        // Persistir o Cliente no banco de dados
        clienteRepository.persist(cliente);

        // Retornar uma representação do funcionário criado
        return ClienteResponseDTO.valueOf(cliente);
    }

    public void validarCpfCliente(String cpf){
        Pessoa cliente = pessoaRepository.findByCpfPessoa(cpf);
        if (cliente != null)
        throw  new ValidationException("cpf", "O  CPF: '"+ cpf +"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto){
        Cliente clienteBanco = clienteRepository.findById(id);
        clienteBanco.setCidade(dto.cidade());
        clienteBanco.setEstado(dto.estado());

         // Criar uma instância de Usuario com os dados do ClienteDTO
        Pessoa pessoa =  clienteBanco.getPessoa();
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setCpf(dto.cpf());
    }

    @Override
    @Transactional
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO findById(Long id){
        return ClienteResponseDTO.valueOf(clienteRepository.findById(id));
    }

    @GET
    public List<ClienteResponseDTO> findAll(){
        return clienteRepository.listAll().stream().map(a -> ClienteResponseDTO.valueOf(a)).toList();
    }
    
    @Override
    public ClienteResponseDTO findByCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);

        if (cliente != null) {
            return ClienteResponseDTO.valueOf(cliente);
        }
        return null;
    }

    @Override
    public List<ClienteResponseDTO> findByEstado(String estado) {
        return clienteRepository.findByEstado(estado).stream().map(clientes -> ClienteResponseDTO.valueOf(clientes)).toList();
    }

    @Override
    public PessoaResponseDTO login (String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
    if (cliente != null) {
        Pessoa pessoa = cliente.getPessoa();
        if (pessoa != null) {
            return PessoaResponseDTO.valueOf(pessoa);
        }
    }
    // Você pode querer lançar uma exceção aqui ou retornar algum tipo de erro
    return null;
    }
}