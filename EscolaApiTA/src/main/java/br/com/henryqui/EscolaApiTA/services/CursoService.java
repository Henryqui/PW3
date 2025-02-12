package br.com.henryqui.EscolaApiTA.services;

import br.com.henryqui.EscolaApiTA.model.Curso;
import br.com.henryqui.EscolaApiTA.repositories.CursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso salvar(Curso curso){
        return cursoRepository.save(curso);
    }

    public Curso atualizar(Integer id, Curso curso){
        Curso cursosalvo = buscarCursoExistente(id);

        BeanUtils.copyProperties(curso, cursosalvo, "Id");

        return cursoRepository.save(cursosalvo); 
    }

    private Curso buscarCursoExistente(Integer id) {
        Optional<Curso> cursoSalvo = cursoRepository.findById(id);

        if(!cursoSalvo.isPresent()){
            throw new IllegalArgumentException();
        }

        return cursoSalvo.get();
    }
}
