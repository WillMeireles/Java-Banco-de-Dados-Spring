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
    public List<Cliente> ListarTodos () {
        return clienteRepository.findAll();
    }
}
