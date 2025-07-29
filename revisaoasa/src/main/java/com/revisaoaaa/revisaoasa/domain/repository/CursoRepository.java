package com.revisaoaaa.revisaoasa.domain.repository;

import com.revisaoaaa.revisaoasa.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
