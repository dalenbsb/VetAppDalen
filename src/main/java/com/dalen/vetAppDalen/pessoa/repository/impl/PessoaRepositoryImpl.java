package com.dalen.vetAppDalen.pessoa.repository.impl;

import com.dalen.vetAppDalen.pessoa.repository.PessoaRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public class PessoaRepositoryImpl implements PessoaRepositoryCustom {
	
	@PersistenceContext
    private EntityManager em;

	
	
}
