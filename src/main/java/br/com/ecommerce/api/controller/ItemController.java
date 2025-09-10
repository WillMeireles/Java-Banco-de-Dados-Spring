package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Item;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ClienteService;
import br.com.ecommerce.api.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ClienteService clienteService;
    private final ItemService itemService;

    public ItemController(ClienteService service, ItemService itemService) {
        clienteService = service;
        this.itemService = itemService;
    }

    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        // 1. Pegar a lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);

    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarItem(
            @RequestBody Item item
    )

    {

            itemService.cadastrarItem(item);

      return ResponseEntity.status(HttpStatus.CREATED).body(item.getIdProduto());

    }

}



