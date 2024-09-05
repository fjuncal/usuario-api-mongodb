package com.usuarioapimongodb.converter;


import com.usuarioapimongodb.infraestrutura.entity.Endereco;
import com.usuarioapimongodb.infraestrutura.entity.Usuario;
import com.usuarioapimongodb.infraestrutura.entity.request.EnderecoRequestDTO;
import com.usuarioapimongodb.infraestrutura.entity.request.UsuarioRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UsuarioConverter {
    public Usuario paraUsuarioEntity(UsuarioRequestDTO usuarioDTO){
        return  Usuario.builder()
                .id(UUID.randomUUID().toString())
                .nome(usuarioDTO.getNome())
                .documento(usuarioDTO.getDocumento())
                .email(usuarioDTO.getEmail())
                .dataCadastro(LocalDateTime.now())
                .build();
    }

    public Endereco paraEnderecoEntity(EnderecoRequestDTO enderecoDTO, String usuarioId){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .bairro(enderecoDTO.getBairro())
                .usuarioId(usuarioId)
                .cep(enderecoDTO.getCep())
                .cidade(enderecoDTO.getCidade())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .build();
    }
}
