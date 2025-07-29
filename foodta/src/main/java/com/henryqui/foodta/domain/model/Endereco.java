package com.henryqui.foodta.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
public class Endereco {

    @Column(name = "endereco_cep")
    private String cep;

    @NotBlank(message = "O seu endereço deve ser obrigatório!")
    @Column(name = "endereco_logradouro" )
    private String logradouro;

    @NotNull(message = "O número da residência é obrigatório")
    @Column(name = "endereco_numero" )
    private String numero;

    @Column(name = "endereco_complemento" )
    private String complemento;

    @Column(name = "endereco_bairro" )
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "endereco_cidade_id")
    private Cidade cidade;
}
