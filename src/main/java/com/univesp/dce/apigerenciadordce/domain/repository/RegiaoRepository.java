package com.univesp.dce.apigerenciadordce.domain.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univesp.dce.apigerenciadordce.domain.model.Regiao;



@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {
    Optional<Regiao> findByNome(String nome);
}
