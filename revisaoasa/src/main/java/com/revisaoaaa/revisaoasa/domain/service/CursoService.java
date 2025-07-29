package com.revisaoaaa.revisaoasa.domain.service;

import com.revisaoaaa.revisaoasa.domain.exception.EntidadeEmUsoException;
import com.revisaoaaa.revisaoasa.domain.exception.EntidadeNaoEncontradaException;
import com.revisaoaaa.revisaoasa.domain.model.Curso;
import com.revisaoaaa.revisaoasa.domain.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso salvar(Curso curso){return cursoRepository.save(curso);}

    public void excluir(Long id){
        try{
            cursoRepository.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Curso ou Codigo %d não pode ser removido, pois está em uso", id));
        }
        catch(EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de curso com código %d", id));
        }
    }
}
