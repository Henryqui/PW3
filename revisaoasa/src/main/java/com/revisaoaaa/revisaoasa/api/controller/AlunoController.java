package com.revisaoaaa.revisaoasa.api.controller;

import com.revisaoaaa.revisaoasa.domain.exception.EntidadeEmUsoException;
import com.revisaoaaa.revisaoasa.domain.exception.EntidadeNaoEncontradaException;
import com.revisaoaaa.revisaoasa.domain.model.Aluno;
import com.revisaoaaa.revisaoasa.domain.repository.AlunoRepository;
import com.revisaoaaa.revisaoasa.domain.service.AlunoService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listar(){return alunoRepository.findAll();}

    @GetMapping("/{alunoId}")
    public ResponseEntity<Aluno> buscar(@PathVariable Long alunoId){
        Optional<Aluno> aluno = alunoRepository.findById(alunoId);

        if (aluno.isPresent()){
            return ResponseEntity.ok(aluno.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Aluno> adicionar(@RequestBody Aluno aluno){
        aluno = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @PutMapping("/{alunoId}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long alunoId, @RequestBody Aluno aluno){
        Optional<Aluno> alunoAtual = alunoRepository.findById(alunoId);

        if (alunoAtual.isPresent()){
            BeanUtils.copyProperties(aluno, alunoAtual, "id");

            Aluno alunoSalvo = alunoService.salvar(alunoAtual.get());
            return ResponseEntity.ok(alunoSalvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Aluno> remover(@PathVariable long alunoId){
        try{
            alunoService.excluir(alunoId);
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

