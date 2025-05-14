package com.henryqui.foodta.domain.repository;

import com.henryqui.foodta.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Query("from Restaurante r join fetch r.cozinha")
    List<Restaurante> findAll();
}
