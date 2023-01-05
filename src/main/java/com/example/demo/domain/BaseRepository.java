package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseDomain> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    Optional<T> findByCode(String code);
}
