package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.ClienteDTO;
import br.unitins.comics.dto.ClienteResponseDTO;
import br.unitins.comics.dto.UpdatePasswordDTO;
import br.unitins.comics.dto.UpdateUsernameDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;
import br.unitins.comics.model.Cliente;
import br.unitins.comics.model.Usuario;
import br.unitins.comics.repository.ClienteRepository;
import br.unitins.comics.repository.EnderecoRepository;
import br.unitins.comics.repository.TelefoneRepository;
import br.unitins.comics.repository.UsuarioRepository;
import br.unitins.comics.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    public ClienteRepository clienteRepository;
    @Inject
    public EnderecoRepository enderecoRepository;
    @Inject
    public TelefoneRepository telefoneRepository;
     @Inject
    public UsuarioRepository usuarioRepository;
    @Inject
    public HashService hashService;


    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
        
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));

        // salvando o usuario
        usuarioRepository.persist(usuario);

        validarNomeCliente(dto.nome());

        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEndereco(enderecoRepository.findById(dto.id_endereco()));
        cliente.setTelefone(telefoneRepository.findById(dto.id_telefone()));
        cliente.setEmail(dto.email());
        cliente.setUsuario(usuario);


        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);
    }

    public void validarNomeCliente(String nome) {
        Cliente cliente = clienteRepository.findByNomeCompleto(nome);
        if (cliente != null)
            throw  new ValidationException("nome", "O nome '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {
        Cliente clienteBanco =  clienteRepository.findById(id);
        
        clienteBanco.setNome(dto.nome());
        clienteBanco.setEndereco(enderecoRepository.findById(dto.id_endereco()));
        clienteBanco.setTelefone(telefoneRepository.findById(dto.id_telefone()));
        clienteBanco.setEmail(dto.email());

    }

    @Override
    @Transactional
    public void updatePassword(Long id, UpdatePasswordDTO dto) {

        Cliente cliente = clienteRepository.findById(id);
        String hashSenhaAntiga = hashService.getHashSenha(dto.oldPassword());

        if (cliente != null) {
            if (cliente.getUsuario().getSenha().equals(hashSenhaAntiga)) {
                String hashNovaSenha = hashService.getHashSenha(dto.newPassword());
                cliente.getUsuario().setSenha(hashNovaSenha);
            } else {
                throw new ValidationException("ERRO", "Senha antiga nao corresponde");
            }
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    @Transactional
    public void updateUsername(Long id, UpdateUsernameDTO dto) {

        Cliente cliente = clienteRepository.findById(id);

        if (cliente != null) {
            cliente.getUsuario().setUsername(dto.newUsername());;
        } else {
            throw new NotFoundException();
        }
    }


    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(clienteRepository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        return clienteRepository
        .listAll()
        .stream()
        .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        return clienteRepository.findByNome(nome).stream()
        .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    public UsuarioResponseDTO login(String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);

        if (cliente !=null){
            return UsuarioResponseDTO.valueOf(cliente);
        }else{
            return null;
        }

    }

}
