package com.nosso_fluxo.Nosso.Fluxo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "grupos")
    private Set<Usuario> usuarios = new HashSet<>();
    //private long balanco;
    //private String idConvite;
}
