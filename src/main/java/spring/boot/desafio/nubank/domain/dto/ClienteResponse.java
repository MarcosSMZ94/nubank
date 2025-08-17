package spring.boot.desafio.nubank.domain.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import spring.boot.desafio.nubank.domain.entity.Contato;

public record ClienteResponse (@NotBlank UUID id, @NotBlank String nome, @NotBlank List<Contato> contatos) {}
