package com.usuarioapimongodb.infraestrutura.repository;

import com.usuarioapimongodb.infraestrutura.entity.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnderecoRepository extends MongoRepository<Endereco, String> {
}
