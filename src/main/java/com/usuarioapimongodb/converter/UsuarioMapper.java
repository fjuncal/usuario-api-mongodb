package com.usuarioapimongodb.converter;


import com.usuarioapimongodb.infraestrutura.entity.Usuario;
import com.usuarioapimongodb.infraestrutura.entity.response.UsuarioResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UsuarioMapper {
    UsuarioResponseDTO paraUsuarioResponseDTO(Usuario usuario);
}
