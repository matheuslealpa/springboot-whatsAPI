package com.springbootwhatsapi.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cod_pais")
    private String codPais;

    @Column(name = "cod_ddd")
    private String codDDD;

    @Column(name = "numero")
    private String numero;
}
