package spring.boot.desafio.nubank.domain.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import spring.boot.desafio.nubank.domain.entity.Cliente;

public record ContatoResponse (@NotNull UUID id, @NotBlank String telefone, @NotBlank String email, @NotNull Cliente cliente) {}
