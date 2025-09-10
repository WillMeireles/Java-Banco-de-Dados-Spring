package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Item;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ItemRepository;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    // Injecao de dependencia
    //  Falar que Service depende de alguem
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository repo) {
        itemRepository = repo;
    }

    // Listar todos os Clientes
    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }


    public Item cadastrarItem(Item it) {
        return itemRepository.save(it);
    }

}