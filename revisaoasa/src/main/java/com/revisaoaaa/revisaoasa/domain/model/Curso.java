package com.revisaoaaa.revisaoasa.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(name = "Curso")
public class Curso {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "nomecurso", length = 100)
    private String nomecurso;

    @CreationTimestamp
    @Column( name = "datacadastro", columnDefinition = "datetime")
    private LocalDateTime datacadastro;

    @UpdateTimestamp
    @Column( name = "data_atualizacao", columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

}
