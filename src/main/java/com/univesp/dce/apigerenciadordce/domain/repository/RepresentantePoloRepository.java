package com.univesp.dce.apigerenciadordce.domain.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univesp.dce.apigerenciadordce.domain.model.RepresentantePolo;

@Repository
public interface RepresentantePoloRepository extends JpaRepository<RepresentantePolo, Long> {
   
}
