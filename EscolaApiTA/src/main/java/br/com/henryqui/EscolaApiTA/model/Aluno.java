package br.com.henryqui.EscolaApiTA.model;

import jakarta.persistence.*;

@Entity
@Table(name="aluno")
public class Aluno {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "cursoid")
    private Curso curso;

}
