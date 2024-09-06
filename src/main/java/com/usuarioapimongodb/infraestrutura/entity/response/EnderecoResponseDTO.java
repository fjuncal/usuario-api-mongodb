package com.usuarioapimongodb.infraestrutura.entity.response;

import java.io.Serializable;

public record EnderecoResponseDTO(String rua,

                                  Long numero,

                                  String bairro,

                                  String complemento,

                                  String cidade,

                                  String cep) implements Serializable {
}
