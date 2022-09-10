package com.springbootwhatsapi.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToMany
    private List<Telefone> telefones;

    @ElementCollection
    private List<String> emails = new ArrayList<>();

}
