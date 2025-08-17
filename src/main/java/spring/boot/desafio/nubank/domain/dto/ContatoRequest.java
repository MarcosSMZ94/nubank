package spring.boot.desafio.nubank.domain.dto;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoRequest(@NotBlank String telefone, @Email @NotBlank String email, @NotNull UUID clienteId ) {}
 