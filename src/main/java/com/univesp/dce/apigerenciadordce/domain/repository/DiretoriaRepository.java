package com.univesp.dce.apigerenciadordce.domain.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univesp.dce.apigerenciadordce.domain.model.Diretoria;



@Repository
public interface DiretoriaRepository extends JpaRepository<Diretoria, Long> {
    Optional<Diretoria> findByNome(String nome);
}
