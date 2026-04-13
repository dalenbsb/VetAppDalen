package com.dalen.vetAppDalen.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalen.vetAppDalen.pessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>,  PessoaRepositoryCustom {

}
