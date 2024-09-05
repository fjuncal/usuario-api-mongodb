package com.usuarioapimongodb.infraestrutura.repository;

import com.usuarioapimongodb.infraestrutura.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    void deleteByEmail(String email);

    Usuario findByEmail(String email);


}
