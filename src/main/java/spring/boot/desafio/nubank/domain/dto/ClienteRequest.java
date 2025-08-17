package spring.boot.desafio.nubank.domain.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import spring.boot.desafio.nubank.domain.entity.Contato;

public record ClienteRequest(@NotBlank String nome, @NotBlank List<Contato> contatos) {}
