package com.isra.pratice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isra.pratice.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
