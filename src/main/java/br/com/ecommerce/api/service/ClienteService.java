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

    public Cliente deletarCliente (Integer id) {
        Cliente cliente = buscarPorid(id);

        //2. Se nao existir, retorno nulo
        if (cliente == null) {
            return null;

            //3. Se existir, excluo
            clienteRepository.delete(cliente);

        }
        //1. Verifico se o cliente existe
        Cliente cliente = cliente.Service.deletarCliente(id);



        // 2. Se não existir retorno erro
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente " + id + " não encontrado!");
        }

        // 3. Se existir, retorno ok
        return ResponseEntity.ok(cliente);

    }




