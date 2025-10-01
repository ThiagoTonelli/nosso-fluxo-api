package com.nosso_fluxo.Nosso.Fluxo.autenticacao.autenticacaoController;

import com.nosso_fluxo.Nosso.Fluxo.autenticacao.autenticacaoService.AutenticacaoService;
import com.nosso_fluxo.Nosso.Fluxo.model.Usuario;
import com.nosso_fluxo.Nosso.Fluxo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticacao")
public class AutenticacaoController {
    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@RequestBody Usuario usuario) {
        return "ok";
    }
}
