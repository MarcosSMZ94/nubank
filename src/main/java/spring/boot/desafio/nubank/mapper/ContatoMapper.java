package spring.boot.desafio.nubank.mapper;

import org.springframework.stereotype.Component;

import spring.boot.desafio.nubank.domain.dto.ContatoRequest;
import spring.boot.desafio.nubank.domain.dto.ContatoResponse;
import spring.boot.desafio.nubank.domain.entity.Contato;

@Component
public class ContatoMapper {
    
    public Contato toEntity(ContatoRequest request) {
        if (request == null) {
            return null;
        }
        
        Contato contato = new Contato();
        contato.setTelefone(request.telefone());
        contato.setEmail(request.email());

        return contato;
    }
    
    public ContatoResponse toResponse(Contato entity) {
        if (entity == null) {
            return null;
        }
        
        return new ContatoResponse(
            entity.getId(),
            entity.getTelefone(),
            entity.getEmail(),
            entity.getClienteId()
        );
    }
}
