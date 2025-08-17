package spring.boot.desafio.nubank.domain.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import spring.boot.desafio.nubank.domain.entity.Cliente;

public record ContatoResponse (@NotBlank UUID id, @NotBlank String telefone, @NotBlank String email, @NotBlank Cliente cliente) {}
