package spring.boot.desafio.nubank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import spring.boot.desafio.nubank.domain.dto.ClienteRequest;
import spring.boot.desafio.nubank.domain.dto.ClienteResponse;
import spring.boot.desafio.nubank.domain.entity.Cliente;
import spring.boot.desafio.nubank.mapper.ClienteMapper;
import spring.boot.desafio.nubank.repository.ClienteRepository;

@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.toEntity(clienteRequest);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toResponse(cliente);
    }

    public List<ClienteResponse> obterTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::toResponse)
                .collect(Collectors.toList());
    }

}
