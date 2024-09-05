package com.usuarioapimongodb.infraestrutura.repository;

import com.usuarioapimongodb.infraestrutura.entity.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EnderecoRepository extends MongoRepository<Endereco, String> {
    Endereco findByUsuarioId(String usuarioId);

    @Transactional
    void deleteByUsuarioId(String usuarioId);
}
