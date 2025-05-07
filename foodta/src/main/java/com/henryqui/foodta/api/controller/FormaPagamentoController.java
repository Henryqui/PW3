package com.henryqui.foodta.api.controller;

import com.henryqui.foodta.domain.exception.EntidadeEmUsoException;
import com.henryqui.foodta.domain.exception.EntidadeNaoEncontradaException;
import com.henryqui.foodta.domain.model.FormaPagamento;
import com.henryqui.foodta.domain.repository.FormaPagamentoRepository;
import com.henryqui.foodta.domain.service.FormaPagamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formapagamentos")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @GetMapping
    public List<FormaPagamento> listar(){ return formaPagamentoRepository.findAll();}


    @GetMapping("/{formaPagamentoId}")
    public ResponseEntity<FormaPagamento> buscar(@PathVariable Long formaPagamentoId){
        Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(formaPagamentoId);

        if (formaPagamento.isPresent()){
            return ResponseEntity.ok(formaPagamento.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> adicionar(@RequestBody FormaPagamento formaPagamento){
        formaPagamento = formaPagamentoService.salvar(formaPagamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamento);

    }

    @PutMapping("/{formaPagamentoId}")
    public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long formaPagamentoId, @RequestBody FormaPagamento formaPagamento){
        Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRepository.findById(formaPagamentoId);

        if (formaPagamentoAtual.isPresent()){
            BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual, "id");

            FormaPagamento formaPagamentoSalvo = formaPagamentoService.salvar(formaPagamentoAtual.get());
            return ResponseEntity.ok(formaPagamentoSalvo);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{formaPagamentoId}")
    public ResponseEntity<FormaPagamento> remover(@PathVariable Long formaPagamentoId){
        try{
            formaPagamentoService.excluir(formaPagamentoId);
            return ResponseEntity.notFound().build();
        }
        catch(EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
        catch(EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
