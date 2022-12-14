package com.univesp.dce.apigerenciadordce.domain.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univesp.dce.apigerenciadordce.domain.model.Eixo;


@Repository
public interface EixoRepository extends JpaRepository<Eixo, Long>{
    Optional<Eixo> findByNome(String nome);
}
