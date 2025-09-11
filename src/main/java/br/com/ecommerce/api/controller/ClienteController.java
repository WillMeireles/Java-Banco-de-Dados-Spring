package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
private final ClienteService clienteService;

public ClienteController(ClienteService service) {
 clienteService = service;

}

//Listar Todos
  @GetMapping
  public ResponseEntity<List<Cliente>>listarClientes(){
    // 1. Pegar a lista de clientes
    List<Cliente> clientes = clienteService.listarTodos();
    return ResponseEntity.ok(clientes);

  }

@PostMapping
  public ResponseEntity<Cliente> cadastrarCliente (
  @RequestBody Cliente cliente
)

{

  // 1. Tentar cadastrar o cliente
  clienteService.cadastrarCliente(cliente);


  // Codigo 200 - OK
  //return ResponseEntity.ok(cliente);

  // Codigo 201 - CREATED
  return ResponseEntity.status(HttpStatus.CREATED).body(cliente);


  }

  // Buscar Cliente por id
  // GET, POST, PUT, DELETE
  @GetMapping("/{id}")
  // Path Variable -> Recebe um valor no LINK
  // Request Body -> Recebe dados pelo corpo
  public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
    // 1. Procurar e guardar o Cliente
    Cliente cliente = clienteService.buscarPorId(id);

    if (cliente == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente" + id + " nao encontrado!");

    }

    return ResponseEntity.ok(cliente);

}

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletarCliente(@PathVariable Integer id) {
    // 1. Verifico se o cliente existe
    Cliente cliente = clienteService.deletarCliente(id);

    // 2. Se não existir retorno erro
    if (cliente == null) {
      return ResponseEntity.status(404)
              .body("Cliente " + id + " não encontrado!");
    }

    // 3. Se existir, retorno ok
    return ResponseEntity.ok(cliente);
  }

}



