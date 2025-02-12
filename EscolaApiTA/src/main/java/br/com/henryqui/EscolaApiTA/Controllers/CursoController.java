package br.com.henryqui.EscolaApiTA.Controllers;

import br.com.henryqui.EscolaApiTA.model.Curso;
import br.com.henryqui.EscolaApiTA.repositories.CursoRepository;
import br.com.henryqui.EscolaApiTA.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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


    @GetMapping()
    public List<Curso> listarTodosCursos(){
    return cursoRepository.findAll(Sort.by("nomecurso").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPeloCodigo(@PathVariable int id){
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.isPresent() ? ResponseEntity.ok(curso.get()) : ResponseEntity.notFound().build();

    }

    @PutMapping
    public ResponseEntity<Curso> atualizar(@PathVariable int id, @RequestBody Curso curso) {
        Curso cursosalvo = cursoService.atualizar(id, curso);
        return ResponseEntity.ok(cursosalvo);
    }
}