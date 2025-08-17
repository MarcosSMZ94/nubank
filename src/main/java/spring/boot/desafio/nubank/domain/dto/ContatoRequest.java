package spring.boot.desafio.nubank.domain.dto;

import jakarta.validation.constraints.NotBlank;
import spring.boot.desafio.nubank.domain.entity.Cliente;

public record ContatoRequest (@NotBlank String telefone, @NotBlank String email, @NotBlank Cliente cliente) {}
