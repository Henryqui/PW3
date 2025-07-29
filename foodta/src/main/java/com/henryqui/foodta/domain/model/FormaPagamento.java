package com.henryqui.foodta.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "formaPagamento")
public class FormaPagamento {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero(message = "O valor da forma de pagamento deve ser um Valor Positivo!")
    @NotNull(message = "A forma de pagamento é Obrigatória!")
    @Column(name = "descricaoForma", length = 100)
    private String descricaoForma;

}
