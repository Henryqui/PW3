package br.com.henryqui.EscolaApiTA.Controllers;

import br.com.henryqui.EscolaApiTA.model.Aluno;
import br.com.henryqui.EscolaApiTA.repositories.AlunoRepository;
import br.com.henryqui.EscolaApiTA.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("./alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @GetMapping()
    public List<Aluno> listarTodosAluno(){
        return alunoRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPeloCodigo(@PathVariable int id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.isPresent() ? ResponseEntity.ok(aluno.get()) : ResponseEntity.notFound().build();

    }

    @PostMapping()
    public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno) {

        Aluno alunoSalvo = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);

    }
}
