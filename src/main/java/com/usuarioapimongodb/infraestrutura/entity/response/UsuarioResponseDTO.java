package com.usuarioapimongodb.infraestrutura.entity.response;

public record UsuarioResponseDTO(String id,

                                 String nome,

                                 String email,

                                 String documento,

                                 EnderecoResponseDTO endereco) {
}
