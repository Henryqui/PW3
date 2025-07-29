package com.revisaoaaa.revisaoasa.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode( onlyExplicitlyIncluded = true )
@Entity
@Table( name = "Aluno")
public class Aluno {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "nome", length = 100)
    private String nome;

    @CreationTimestamp
    @Column( name = "datacadastro", columnDefinition = "datetime")
    private LocalDateTime datacadastro;

    @UpdateTimestamp
    @Column( name = "dataAtualizacao", columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
