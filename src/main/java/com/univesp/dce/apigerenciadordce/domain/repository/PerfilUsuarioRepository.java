package com.univesp.dce.apigerenciadordce.domain.repository;

import org.springframework.stereotype.Repository;

import com.univesp.dce.apigerenciadordce.domain.model.PerfilUsuario;
import java.util.Optional;

@Repository
public interface PerfilUsuarioRepository extends CustomJpaRepository<PerfilUsuario, Long>{

    Optional<PerfilUsuario> findByEmailAcademico(String email);
}
