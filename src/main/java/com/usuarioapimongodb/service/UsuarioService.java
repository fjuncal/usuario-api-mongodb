package com.usuarioapimongodb.service;


import com.usuarioapimongodb.converter.UsuarioConverter;
import com.usuarioapimongodb.converter.UsuarioMapper;
import com.usuarioapimongodb.infraestrutura.entity.Endereco;
import com.usuarioapimongodb.infraestrutura.entity.Usuario;
import com.usuarioapimongodb.infraestrutura.entity.request.UsuarioRequestDTO;
import com.usuarioapimongodb.infraestrutura.entity.response.UsuarioResponseDTO;
import com.usuarioapimongodb.infraestrutura.exceptions.BusinessException;
import com.usuarioapimongodb.infraestrutura.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import static org.springframework.util.Assert.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final UsuarioMapper usuarioMapper;
    private final EnderecoService enderecoService;

    public UsuarioResponseDTO gravarUsuarios(UsuarioRequestDTO usuarioRequestDTO) {
        try {
            notNull(usuarioRequestDTO, "Os dados do usuário são obrigatórios");
            Usuario usuario = salvarUsuario(usuarioConverter.paraUsuarioEntity(usuarioRequestDTO));
            Endereco endereco = enderecoService.salvaEndereco(usuarioConverter.paraEnderecoEntity(usuarioRequestDTO.getEndereco(), usuario.getId()));

            return usuarioMapper.paraUsuarioResponseDTO(usuario, endereco);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de usuário", e);
        }
    }

    public UsuarioResponseDTO buscarDadosUsuario(String email) {
        try {
            Usuario usuarioByEmail = usuarioRepository.findByEmail(email);
            notNull(usuarioByEmail, "Usuário não encontrado");
            Endereco enderecoByUsuarioId = enderecoService.findByUsuarioId(usuarioByEmail.getId());

            return usuarioMapper.paraUsuarioResponseDTO(usuarioByEmail, enderecoByUsuarioId);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de usuário", e);
        }

    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    @Transactional
    public void deletarDadosUsuario(String email) {
        Usuario usuarioByEmail = usuarioRepository.findByEmail(email);
        enderecoService.deleteByUsuarioId(usuarioByEmail.getId());
        usuarioRepository.deleteByEmail(email);

    }
}
