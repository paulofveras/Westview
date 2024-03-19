package br.unitins.comics.service;

import java.util.List;

import br.unitins.comics.dto.PessoaClienteDTO;
import br.unitins.comics.model.Pessoa;
import br.unitins.comics.model.PessoaCliente;
import br.unitins.comics.repository.PessoaClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PessoaClienteService {
    @Inject
    private PessoaService pessoaService;

    @Inject
    private PessoaClienteRepository PessoaclienteRepository;

    @Transactional
    public PessoaCliente criarPessoaCliente(PessoaClienteDTO pessoaClienteDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaClienteDTO.getPessoa().getNome());
        pessoa.setCpf(pessoaClienteDTO.getPessoa().getCpf());
        pessoaService.criarPessoa(pessoa); // Persiste a pessoa

        PessoaCliente pessoaCliente = new PessoaCliente();
        pessoaCliente.setPessoa(pessoa);
        pessoaCliente.setEmail(pessoaClienteDTO.getEmail());
        pessoaCliente.setTelefone(pessoaClienteDTO.getTelefone());
        PessoaclienteRepository.persist(pessoaCliente); // Persiste o PessoaCliente
        return pessoaCliente;
    }
    public List<PessoaCliente> listarPessoaClientes() {
        return PessoaclienteRepository.listAll();
    }

    public PessoaCliente buscarPessoaCliente(Long id) {
        return PessoaclienteRepository.findById(id);
    }

    @Transactional
    public void atualizarPessoaCliente(Long id, PessoaClienteDTO PessoaclienteDTO) {
        PessoaCliente Pessoacliente = buscarPessoaCliente(id);
        if (Pessoacliente != null) {
            Pessoacliente.setPessoa(PessoaclienteDTO.getPessoa());
            Pessoacliente.setEmail(PessoaclienteDTO.getEmail());
            Pessoacliente.setTelefone(PessoaclienteDTO.getTelefone());
            PessoaclienteRepository.persist(Pessoacliente);
        }
    }

    @Transactional
    public void excluirPessoaCliente(Long id) {
        PessoaCliente Pessoacliente = buscarPessoaCliente(id);
        if (Pessoacliente != null) {
            PessoaclienteRepository.delete(Pessoacliente);
        }
    }
}
