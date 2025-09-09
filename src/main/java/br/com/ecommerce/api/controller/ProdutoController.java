package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ClienteService;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public ProdutoController(ClienteService service, ProdutoService produtoService) {
        clienteService = service;
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        // 1. Pegar a lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);

    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(
            @RequestBody Produto produto

    )

    {

        produtoService.cadastrarProduto(produto);

      return ResponseEntity.status(HttpStatus.CREATED).body(produto);

}

}
