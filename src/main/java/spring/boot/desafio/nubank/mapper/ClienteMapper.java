package spring.boot.desafio.nubank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import spring.boot.desafio.nubank.domain.dto.ClienteRequest;
import spring.boot.desafio.nubank.domain.dto.ClienteResponse;
import spring.boot.desafio.nubank.domain.entity.Cliente;
import spring.boot.desafio.nubank.domain.entity.Contato;

@Component
public class ClienteMapper {
    
    public Cliente toEntity(ClienteRequest request) {
        if (request == null) {
            return null;
        }
        
        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        
        List<Contato> contatos = request.contatos().stream()
                .map(contato -> {
                    Contato novoContato = new Contato();
                    novoContato.setTelefone(contato.getTelefone());
                    novoContato.setEmail(contato.getEmail());
                    novoContato.setCliente(cliente); 
                    return novoContato;
                })
                .collect(Collectors.toList());
        cliente.setContatos(contatos);

        return cliente;
    }
    
    public ClienteResponse toResponse(Cliente entity) {
        if (entity == null) {
            return null;
        }
        
        return new ClienteResponse(
            entity.getId(),
            entity.getNome(),
            entity.getContatos()
        );
    }
}
