package com.usuarioapimongodb.infraestrutura.entity.response;

import java.io.Serializable;

public record UsuarioResponseDTO(String id,

                                 String nome,

                                 String email,

                                 String documento,

                                 EnderecoResponseDTO endereco) implements Serializable {
}
