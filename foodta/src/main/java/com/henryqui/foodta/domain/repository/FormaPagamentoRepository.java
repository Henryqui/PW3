package com.henryqui.foodta.domain.repository;


import com.henryqui.foodta.domain.model.Estado;
import com.henryqui.foodta.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.text.Normalizer;
import java.util.List;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
