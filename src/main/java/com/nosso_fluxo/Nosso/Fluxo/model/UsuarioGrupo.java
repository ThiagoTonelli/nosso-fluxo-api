package com.nosso_fluxo.Nosso.Fluxo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class UsuarioGrupo {
    private long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id")
    private Grupo grupo;
}
