package com.univesp.dce.apigerenciadordce.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univesp.dce.apigerenciadordce.domain.model.Curso;



@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
