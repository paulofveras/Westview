package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ClienteDTO;
import br.unitins.comics.dto.ClienteResponseDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;
import br.unitins.comics.model.Cliente;
import br.unitins.comics.model.Usuario;
import br.unitins.comics.repository.ClienteRepository;
import br.unitins.comics.repository.UsuarioRepository;
import br.unitins.comics.service.hash.HashService;
import br.unitins.comics.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    public HashService hashService;

    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto){
        validarCpfCliente(dto.cpf());

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha())); 
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setGenero(dto.genero());

        usuarioRepository.persist(usuario);

        Cliente cliente = new Cliente();
        cliente.setEndereco(dto.endereco());
        cliente.setCep(dto.cep());
        cliente.setCidade(dto.cidade());
        cliente.setEstado(dto.estado());
        cliente.setUsuario(usuario);

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);
    }

    public void validarCpfCliente(String cpf){
        Usuario cliente = usuarioRepository.findByCpfUsuario(cpf);
        if (cliente != null)
            throw new ValidationException("cpf", "O CPF: '"+ cpf +"' já existe.");
    }   

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto){
        Cliente clienteBanco = clienteRepository.findById(id);
        if (clienteBanco == null) {
            throw new NotFoundException("Cliente não encontrado");
        }

        clienteBanco.setEndereco(dto.endereco());
        clienteBanco.setCep(dto.cep());
        clienteBanco.setCidade(dto.cidade());
        clienteBanco.setEstado(dto.estado());

        Usuario usuario = clienteBanco.getUsuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha())); 
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setGenero(dto.genero());
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
    public List<ClienteResponseDTO> findByEstado(String estado) {
        return clienteRepository.findByEstado(estado).stream().map(clientes -> ClienteResponseDTO.valueOf(clientes)).toList();
    }

    @Override
    public List<UsuarioResponseDTO> findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).stream().map(c -> UsuarioResponseDTO.valueof(c)).toList();
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);

        if (cliente !=null){
            return UsuarioResponseDTO.valueOf(cliente);
        }else{
            return null;
        }

    }
    
}