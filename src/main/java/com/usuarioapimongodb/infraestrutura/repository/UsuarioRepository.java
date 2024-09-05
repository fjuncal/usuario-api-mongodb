package com.usuarioapimongodb.infraestrutura.repository;

import com.usuarioapimongodb.infraestrutura.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    @Transactional
    void deleteByEmail(String email);


    Usuario findByEmail(String email);


}
