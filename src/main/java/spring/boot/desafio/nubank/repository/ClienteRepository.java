package spring.boot.desafio.nubank.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.desafio.nubank.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    
}
