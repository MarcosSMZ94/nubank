package spring.boot.desafio.nubank.mapper;

import spring.boot.desafio.nubank.domain.dto.ContatoRequest;
import spring.boot.desafio.nubank.domain.dto.ContatoResponse;
import spring.boot.desafio.nubank.domain.entity.Contato;

public class ContatoMapper {
    
    public static Contato toEntity(ContatoRequest request) {
        if (request == null) {
            return null;
        }
        
        Contato contato = new Contato();
        contato.setTelefone(request.telefone());
        contato.setEmail(request.email());
        contato.setCliente(request.cliente());
        
        return contato;
    }
    
    public static ContatoResponse toResponse(Contato entity) {
        if (entity == null) {
            return null;
        }
        
        return new ContatoResponse(
            entity.getId(),
            entity.getTelefone(),
            entity.getEmail(),
            entity.getCliente()
        );
    }
}
