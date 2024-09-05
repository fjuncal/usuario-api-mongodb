package com.usuarioapimongodb.service;


import com.usuarioapimongodb.infraestrutura.entity.Endereco;
import com.usuarioapimongodb.infraestrutura.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public Endereco salvaEndereco(Endereco enderecoEntity) {
        return enderecoRepository.save(enderecoEntity);
    }

    public Endereco findByUsuarioId(String usuarioId) {
        return enderecoRepository.findByUsuarioId(usuarioId);
    }

    public void deleteByUsuarioId(String usuarioId) {
        enderecoRepository.deleteByUsuarioId(usuarioId);
    }
}
