package com.univesp.dce.apigerenciadordce.domain.repository;

import com.univesp.dce.apigerenciadordce.domain.model.GrupoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, Long> {

}

