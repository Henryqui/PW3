package com.henryqui.foodta.domain.repository;

import com.henryqui.foodta.domain.model.Cidade;
import com.henryqui.foodta.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("From Cidade c join fetch c.estado")
    List<Cidade> findAll();

}
