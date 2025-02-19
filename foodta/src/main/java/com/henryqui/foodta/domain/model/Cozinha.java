package com.henryqui.foodta.domain.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cozinha")
public class Cozinha {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cozinha", length = 50)
    private String nome;

}
