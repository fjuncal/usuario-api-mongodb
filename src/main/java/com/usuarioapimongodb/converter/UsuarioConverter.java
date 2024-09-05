package com.usuarioapimongodb.converter;


import com.usuarioapimongodb.infraestrutura.entity.Endereco;
import com.usuarioapimongodb.infraestrutura.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UsuarioConverter {
    public Usuario paraUsuarioEntity(){
        return Usuario.builder()
                .nome("Juncal")
                .documento("123456789")
                .email("bJ4Qc@example.com")
                .dataCadastro(LocalDateTime.now())
                .build();
    }

    public Endereco paraEnderecoEntity(){
        return Endereco.builder()
                .rua("Rua teste")
                .bairro("Bairro teste")
                .cep("12345678")
                .cidade("RJ")
                .numero(123L)
                .complemento("Complemento teste")
                .build();
    }
}
