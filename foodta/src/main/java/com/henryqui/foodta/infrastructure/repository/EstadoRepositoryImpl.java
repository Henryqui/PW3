package com.henryqui.foodta.infrastructure.repository;


import com.henryqui.foodta.domain.model.Estado;
import com.henryqui.foodta.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar() {
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }

    @Override
    public Estado buscar(Long id) {
        return null;
    }

    @Override
    public Estado salvar(Estado estado) {
        return null;
    }

    @Override
    public void remover(Long id) {

    }
}
