package com.projetoapi.controller;

import com.projetoapi.dto.BaseResponseDto;
import com.projetoapi.dto.UsuarioPatchRequestDto;
import com.projetoapi.dto.UsuarioRequestDto;
import com.projetoapi.model.Usuario;
import com.projetoapi.repository.UsuarioRepository;
import com.projetoapi.service.UsuarioService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> cadastrar (@RequestBody UsuarioRequestDto usuarioRequestDto) {
        try {
            return BaseController.feito(usuarioService.cadastrarUsuario(usuarioRequestDto));

        } catch (RuntimeException e) {
            return BaseController.erro(usuarioService.cadastrarUsuario(usuarioRequestDto));
        }

    }
    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponseDto> atualizandoCadastro(@PathVariable Long id, @RequestBody UsuarioPatchRequestDto usuarioPatchRequestDto) {
        try {
            return BaseController.feito(usuarioService.atualizandoUsuario(id, usuarioPatchRequestDto));
        } catch (RuntimeException e) {
            return BaseController.erro(e.getMessage());

        }

    }


}
