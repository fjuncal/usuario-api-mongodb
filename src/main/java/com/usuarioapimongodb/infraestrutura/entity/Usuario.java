package com.usuarioapimongodb.infraestrutura.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collation = "usuario")
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String email;
    private String usuarioId;
    private String documento;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
}
