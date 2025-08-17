package spring.boot.desafio.nubank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring.boot.desafio.nubank.domain.dto.ContatoRequest;
import spring.boot.desafio.nubank.domain.dto.ContatoResponse;
import spring.boot.desafio.nubank.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<ContatoResponse> criarContato(@RequestBody @Valid ContatoRequest contatoRequest) {
        ContatoResponse response = contatoService.criarContato(contatoRequest);
        if (response == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }
}
