package spring.boot.desafio.nubank.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import spring.boot.desafio.nubank.domain.entity.Cliente;

public record ContatoRequest (@NotBlank String telefone, @NotBlank String email, @NotNull Cliente cliente) {}
