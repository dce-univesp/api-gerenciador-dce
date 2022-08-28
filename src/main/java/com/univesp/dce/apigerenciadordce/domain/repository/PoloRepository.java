package com.univesp.dce.apigerenciadordce.domain.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univesp.dce.apigerenciadordce.domain.model.Polo;



@Repository
public interface PoloRepository extends JpaRepository<Polo, Long>{
    Optional<Polo> findByNome(String nome);
}
