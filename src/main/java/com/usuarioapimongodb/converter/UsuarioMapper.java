package com.usuarioapimongodb.converter;


import com.usuarioapimongodb.infraestrutura.entity.Endereco;
import com.usuarioapimongodb.infraestrutura.entity.Usuario;
import com.usuarioapimongodb.infraestrutura.entity.response.UsuarioResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UsuarioMapper {

    @Mapping(target = "id", source = "usuario.id")
    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "documento", source = "usuario.documento")
    @Mapping(target = "endereco", source = "endereco")
    UsuarioResponseDTO paraUsuarioResponseDTO(Usuario usuario, Endereco endereco);
}
