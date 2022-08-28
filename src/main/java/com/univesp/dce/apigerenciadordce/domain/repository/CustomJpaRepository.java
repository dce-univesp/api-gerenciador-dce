package com.univesp.dce.apigerenciadordce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface CustomJpaRepository<T, id> extends JpaRepository<T, id> {

    //Optional<T> buscarPrimeiro();

    //void detach(T entity);

}