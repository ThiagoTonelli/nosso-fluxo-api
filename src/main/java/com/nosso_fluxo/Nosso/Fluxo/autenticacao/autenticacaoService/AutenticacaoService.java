package com.nosso_fluxo.Nosso.Fluxo.autenticacao.autenticacaoService;
import com.nosso_fluxo.Nosso.Fluxo.model.Usuario;
import com.nosso_fluxo.Nosso.Fluxo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity cadastroUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        String senhaHashed = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaHashed);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity loginUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            String senhaUsuarioBD = usuarioRepository.findByEmail(usuario.getEmail()).getSenha();
            if(passwordEncoder.matches(usuario.getSenha(), senhaUsuarioBD)) {
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
