package com.revisaoaaa.revisaoasa.domain.service;

import com.revisaoaaa.revisaoasa.domain.exception.EntidadeEmUsoException;
import com.revisaoaaa.revisaoasa.domain.exception.EntidadeNaoEncontradaException;
import com.revisaoaaa.revisaoasa.domain.model.Aluno;
import com.revisaoaaa.revisaoasa.domain.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno){return alunoRepository.save(aluno);}

    public void excluir(Long id){
        try{
            alunoRepository.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Aluno ou Codigo %d não pode ser removido, pois está em uso", id));
        }
        catch(EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de Aluno com código %d", id));
        }
    }
}
