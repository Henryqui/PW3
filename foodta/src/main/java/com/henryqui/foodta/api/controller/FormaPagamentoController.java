package com.henryqui.foodta.api.controller;

import com.henryqui.foodta.domain.model.Cozinha;
import com.henryqui.foodta.domain.model.FormaPagamento;
import com.henryqui.foodta.domain.repository.FormaPagamentoRepository;
import com.henryqui.foodta.domain.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formapagamentos")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @GetMapping
    public List<FormaPagamento> listar(){ return formaPagamentoRepository.listar();}


    @GetMapping("/{formaPagamentoId}")
    public ResponseEntity<FormaPagamento> buscar(@PathVariable Long formaPagamentoId){
        FormaPagamento formaPagamento = formaPagamentoRepository.buscar(formaPagamentoId);

        if (formaPagamento != null){
            return ResponseEntity.ok(formaPagamento);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento){
        return formaPagamentoService.salvar(formaPagamento);

    }

}
