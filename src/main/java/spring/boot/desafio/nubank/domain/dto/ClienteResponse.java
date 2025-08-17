package spring.boot.desafio.nubank.domain.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import spring.boot.desafio.nubank.domain.entity.Contato;

public record ClienteResponse (@NotNull UUID id, @NotBlank String nome, @NotNull List<Contato> contatos) {}
