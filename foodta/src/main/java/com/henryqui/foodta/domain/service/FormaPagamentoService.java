package com.henryqui.foodta.domain.service;

import com.henryqui.foodta.domain.model.FormaPagamento;
import com.henryqui.foodta.domain.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamento salvar(FormaPagamento formaPagamento){return formaPagamentoRepository.salvar(formaPagamento);}
}
