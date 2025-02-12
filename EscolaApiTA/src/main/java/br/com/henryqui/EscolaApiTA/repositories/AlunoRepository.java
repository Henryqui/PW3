package br.com.henryqui.EscolaApiTA.repositories;

import br.com.henryqui.EscolaApiTA.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {}
