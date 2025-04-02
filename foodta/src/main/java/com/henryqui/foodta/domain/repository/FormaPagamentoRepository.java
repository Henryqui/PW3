package com.henryqui.foodta.domain.repository;


import com.henryqui.foodta.domain.model.FormaPagamento;
import org.springframework.stereotype.Repository;

import java.text.Normalizer;
import java.util.List;

@Repository
public interface FormaPagamentoRepository {

    List<FormaPagamento> listar();

    FormaPagamento buscar(Long id);

    FormaPagamento salvar(FormaPagamento formaPagamento);

    void remover(Long id);
}
