package spring.boot.desafio.nubank.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.desafio.nubank.domain.dto.ClienteRequest;
import spring.boot.desafio.nubank.domain.dto.ClienteResponse;
import spring.boot.desafio.nubank.domain.dto.ContatoResponse;
import spring.boot.desafio.nubank.service.ClienteService;
import spring.boot.desafio.nubank.service.ContatoService;



@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ContatoService contatoService;

    public ClienteController(ClienteService clienteService, ContatoService contatoService) {
        this.clienteService = clienteService;
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> criarCliente(@RequestBody ClienteRequest clienteRequest) {
        ClienteResponse response = clienteService.criarCliente(clienteRequest);
        if (response == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obterTodosClientes() {
        List<ClienteResponse> clientes = clienteService.obterTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatoResponse>> obterContatosPorId(@PathVariable UUID id) {
        List<ContatoResponse> response = contatoService.obterContatosPorClienteId(id);
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
