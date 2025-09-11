package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    // Injecao de dependencia
    //  Falar que Service depende de alguem
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repo) {
        clienteRepository = repo;
    }

    // Listar todos os Clientes
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente(Cliente cl) {
        return clienteRepository.save(cl);


    }

    public Cliente buscarPorId(Integer id) {
    return clienteRepository.findById(id).orElse(null);

    }

    public Cliente deletarCliente(Integer id) {
     Cliente cliente = buscarPorId(id);

     if (cliente == null) {
         return null;
     }

     clienteRepository.delete(cliente);
        return cliente;
    }
    public Cliente atualizarCliente(Integer id, Cliente clienteNovo) {
        // 1. Procurar quem eu quero atualizar
        Cliente clienteAntigo = buscarPorId(id);

        // 2. Se eu não achar, retorno nulo
        if (clienteAntigo == null) {
            return null;
        }

        // 3. Se eu achar eu atualizo
        clienteAntigo.setSenha(clienteNovo.getSenha());
        clienteAntigo.setNomeCompleto(clienteNovo.getNomeCompleto());
        clienteAntigo.setDataCadastro(clienteNovo.getDataCadastro());
        clienteAntigo.setTelefone(clienteNovo.getTelefone());
        return clienteRepository.save(clienteAntigo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(
            @PathVariable Integer id, @RequestBody Cliente clienteNovo) {
        // 1. Tento atualizar o Cliente
        Cliente cl = clienteService.atualizarCliente(id, clienteNovo);


        // 2. Se não achar o Cliente, mostro erro
        if (cl == null) {
            return ResponseEntity.status(404)
                    .body("Cliente não encontrado!");
        }

        // 3. Se achar retorno ok
        return ResponseEntity.ok(cl);
    }
    }
















