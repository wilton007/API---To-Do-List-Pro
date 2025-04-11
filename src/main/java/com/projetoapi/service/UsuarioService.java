package com.projetoapi.service;

import com.projetoapi.dto.UsuarioRequestDto;
import com.projetoapi.dto.UsuarioResponseDto;
import com.projetoapi.model.Usuario;
import com.projetoapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDto cadastrarUsuario(UsuarioRequestDto usuarioRequestDto) {
        usuarioExiste(usuarioRequestDto.getEmail());
       return retornaUsuarioResponse(usuarioRepository.save(retornaUsuario(usuarioRequestDto)));

    }

    private Boolean usuarioExiste(String email) {
        Boolean existe = usuarioRepository.existsByEmail(email);
        if (existe) {
            throw new RuntimeException("Email já cadastrado");
        }
        return existe;
    }
    private Usuario retornaUsuario(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDto.getNome());
        usuario.setEmail(usuarioRequestDto.getEmail());
        usuario.setSenha(usuarioRequestDto.getSenha());
        return usuario;
    }
    private UsuarioResponseDto retornaUsuarioResponse(Usuario usuario) {
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setNome(usuario.getNome());
        usuarioResponseDto.setEmail(usuario.getEmail());
        return usuarioResponseDto;

    }

}
