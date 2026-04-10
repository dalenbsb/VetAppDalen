package com.dalen.vetAppDalen.pessoa.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalen.vetAppDalen.pessoa.repository.PessoaService;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/list")
	public Response listPessoa() {
		
		pessoaService.listPessoa();
		
		return null;
	}
	
	@GetMapping("/id")
	public Response getPessoaById(Long id) {
		
		pessoaService.getPessoaById(id);
		
		return null;
	}

}
