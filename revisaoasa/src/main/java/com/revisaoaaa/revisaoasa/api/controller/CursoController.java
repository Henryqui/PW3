package com.revisaoaaa.revisaoasa.api.controller;

import com.revisaoaaa.revisaoasa.domain.model.Curso;
import com.revisaoaaa.revisaoasa.domain.repository.CursoRepository;
import com.revisaoaaa.revisaoasa.domain.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listar(){
        return cursoRepository.findAll();
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<Curso> buscar(@PathVariable Long cursoId){
        Optional<Curso> curso = cursoRepository.findById(cursoId);

        if(curso.isPresent()){
            return ResponseEntity.ok(curso.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Curso> adicionar(@RequestBody Curso curso){
        curso = cursoService.salvar(curso);

        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

    @PutMapping("/{cursoId}")


}
