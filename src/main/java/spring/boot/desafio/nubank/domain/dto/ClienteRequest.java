package spring.boot.desafio.nubank.domain.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import spring.boot.desafio.nubank.domain.entity.Contato;

public record ClienteRequest(@NotBlank String nome, @NotNull List<Contato> contatos) {}
