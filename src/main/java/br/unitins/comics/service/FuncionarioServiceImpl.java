package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.FuncionarioDTO;
import br.unitins.comics.dto.FuncionarioResponseDTO;
import br.unitins.comics.dto.UpdatePasswordDTO;
import br.unitins.comics.dto.UpdateUsernameDTO;
import br.unitins.comics.dto.UsuarioResponseDTO;
import br.unitins.comics.model.Funcionario;
import br.unitins.comics.model.Usuario;
import br.unitins.comics.repository.FuncionarioRepository;
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
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    public HashService hashService;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
        validarCpfFuncionario(dto.cpf());

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha())); 
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setGenero(dto.genero());

        usuarioRepository.persist(usuario);

        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(dto.cargo());
        funcionario.setSalario(dto.salario());
        funcionario.setUsuario(usuario);

        funcionarioRepository.persist(funcionario);

        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    public void validarCpfFuncionario(String cpf) {
        Usuario funcionario = usuarioRepository.findByCpfUsuario(cpf);
        if (funcionario != null)
            throw new ValidationException("cpf", "O CPF: '" + cpf + "' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionarioBanco = funcionarioRepository.findById(id);
        if (funcionarioBanco == null) {
            throw new NotFoundException("Funcionário não encontrado");
        }

        funcionarioBanco.setCargo(dto.cargo());
        funcionarioBanco.setSalario(dto.salario());

        Usuario usuario = funcionarioBanco.getUsuario();
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
    public void updatePassword(Long id, UpdatePasswordDTO dto) {

        Funcionario funcionario = funcionarioRepository.findById(id);
        String hashSenhaAntiga = hashService.getHashSenha(dto.oldPassword());

        if (funcionario != null) {
            if (funcionario.getUsuario().getSenha().equals(hashSenhaAntiga)) {
                String hashNovaSenha = hashService.getHashSenha(dto.newPassword());
                funcionario.getUsuario().setSenha(hashNovaSenha);
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

        Funcionario funcionario = funcionarioRepository.findById(id);

        if (funcionario != null) {
            funcionario.getUsuario().setUsername(dto.newUsername());;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioResponseDTO findById(Long id) {
        return FuncionarioResponseDTO.valueOf(funcionarioRepository.findById(id));
    }

    @GET
    public List<FuncionarioResponseDTO> findAll() {
        return funcionarioRepository.listAll().stream().map(a -> FuncionarioResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<FuncionarioResponseDTO> findByCargo(String cargo) {
        return funcionarioRepository.findByCargo(cargo).stream()
                .map(funcionario -> FuncionarioResponseDTO.valueOf(funcionario)).toList();
    }

    @Override
    public List<UsuarioResponseDTO> findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).stream().map(c -> UsuarioResponseDTO.valueof(c)).toList();
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Funcionario funcionario = funcionarioRepository.findByUsernameAndSenha(username, senha);
        if (funcionario != null){
            return UsuarioResponseDTO.valueOf(funcionario);
        }else{
            return null;
        }
    }
}