package br.com.henryqui.EscolaApiTA.repositories;

import br.com.henryqui.EscolaApiTA.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {}
