package com.usuarioapimongodb.service;


import com.usuarioapimongodb.converter.UsuarioConverter;
import com.usuarioapimongodb.converter.UsuarioMapper;
import com.usuarioapimongodb.infraestrutura.entity.Usuario;
import com.usuarioapimongodb.infraestrutura.entity.request.UsuarioRequestDTO;
import com.usuarioapimongodb.infraestrutura.entity.response.UsuarioResponseDTO;
import com.usuarioapimongodb.infraestrutura.exceptions.BusinessException;
import com.usuarioapimongodb.infraestrutura.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final UsuarioMapper usuarioMapper;

    public UsuarioResponseDTO gravarUsuarios(UsuarioRequestDTO usuarioRequestDTO) {
        try {
            Usuario usuario = salvarUsuario(usuarioConverter.paraUsuarioEntity(usuarioRequestDTO));
            return usuarioMapper.paraUsuarioResponseDTO(usuario);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de usuário", e);
        }
    }

    public UsuarioResponseDTO buscarDadosUsuario(String email) {
        Usuario usuarioByEmail = usuarioRepository.findByEmail(email);
        return usuarioByEmail != null ? usuarioMapper.paraUsuarioResponseDTO(usuarioByEmail) : null;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(String email){
        usuarioRepository.deleteByEmail(email);
    }
}
