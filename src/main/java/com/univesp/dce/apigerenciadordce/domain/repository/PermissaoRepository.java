package com.univesp.dce.apigerenciadordce.domain.repository;

import com.univesp.dce.apigerenciadordce.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository <Permissao, Long> {

}
