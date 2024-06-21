package br.unitins.comics.service;

import br.unitins.comics.dto.CadastroBasicoDTO;
import br.unitins.comics.dto.CadastroBasicoResponseDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;
import br.unitins.comics.model.Cliente;
import br.unitins.comics.model.Endereco;
import br.unitins.comics.model.Telefone;
import br.unitins.comics.model.Usuario;
import br.unitins.comics.repository.ClienteRepository;
import br.unitins.comics.repository.EnderecoRepository;
import br.unitins.comics.repository.TelefoneRepository;
import br.unitins.comics.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CadastroBasicoServiceImpl implements CadastroBasicoService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    public EnderecoRepository enderecoRepository;

    @Inject
    public TelefoneRepository telefoneRepository;

    @Inject
    HashService hashService;

    @Override
   @Transactional
    public CadastroBasicoResponseDTO create(@Valid CadastroBasicoDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));

        usuarioRepository.persist(usuario);

        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());

        telefoneRepository.persist(telefone);

        Endereco endereco = new Endereco();
        endereco.setCep(dto.endereco().cep());
        endereco.setRua(dto.endereco().rua());
        endereco.setNumero(dto.endereco().numero());

        enderecoRepository.persist(endereco);


        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);
        cliente.setUsuario(usuario);

        clienteRepository.persist(cliente);
        return CadastroBasicoResponseDTO.valueOf(cliente);
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(cliente.getUsuario());
    }
    
}