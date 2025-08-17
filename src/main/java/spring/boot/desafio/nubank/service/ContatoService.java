package spring.boot.desafio.nubank.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import spring.boot.desafio.nubank.domain.dto.ContatoRequest;
import spring.boot.desafio.nubank.domain.dto.ContatoResponse;
import spring.boot.desafio.nubank.domain.entity.Cliente;
import spring.boot.desafio.nubank.domain.entity.Contato;
import spring.boot.desafio.nubank.mapper.ContatoMapper;
import spring.boot.desafio.nubank.repository.ClienteRepository;
import spring.boot.desafio.nubank.repository.ContatoRepository;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;
    private final ClienteRepository clienteRepository;

    public ContatoService(ContatoRepository contatoRepository, ContatoMapper contatoMapper, ClienteRepository clienteRepository) {
        this.contatoRepository = contatoRepository;
        this.contatoMapper = contatoMapper;
        this.clienteRepository = clienteRepository;
    }

    public ContatoResponse criarContato(ContatoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("ContatoRequest não pode ser null");
        }
        
        if (request.clienteId() == null) {
            throw new IllegalArgumentException("ClienteId é obrigatório para criar um contato");
        }
        
        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + request.clienteId()));
        
        Contato contato = contatoMapper.toEntity(request);
        contato.setCliente(cliente);
        
        Contato contatoSalvo = contatoRepository.save(contato);
        return contatoMapper.toResponse(contatoSalvo);
    }

    public List<ContatoResponse> obterContatosPorClienteId(UUID id) {
        return contatoRepository.findByCliente_Id(id)
                .stream()
                .map(contatoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
