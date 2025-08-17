package spring.boot.desafio.nubank.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.desafio.nubank.domain.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, UUID>{
    
}
