package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    // Injecao de dependencia
    //  Falar que Service depende de alguem
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository repo) {
        produtoRepository = repo;
    }

    // Listar todos os Clientes
    public List<Produto> listarTodos () {
        return produtoRepository.findAll();
    }
}

