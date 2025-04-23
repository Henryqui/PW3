package com.henryqui.foodta.domain.service;

import com.henryqui.foodta.domain.exception.EntidadeEmUsoException;
import com.henryqui.foodta.domain.exception.EntidadeNaoEncontradaException;
import com.henryqui.foodta.domain.model.Cozinha;
import com.henryqui.foodta.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.salvar(cozinha);
    }

    public void excluir(Long id){
        try {
            cozinhaRepository.remover(id);
        }
        catch(DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Cozinha ou código %d não pode ser removida, pois está em uso.", id));
        }
        catch(EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com código %d", id));
        }
    }
}
