package com.nosso_fluxo.Nosso.Fluxo.repository;

import com.nosso_fluxo.Nosso.Fluxo.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Bean
    boolean existsByEmail(String email);
    @Bean
    Usuario findByEmail(String email);
}
