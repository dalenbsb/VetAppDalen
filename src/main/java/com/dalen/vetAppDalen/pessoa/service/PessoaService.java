package com.dalen.vetAppDalen.pessoa.service;

import java.util.List;

import com.dalen.vetAppDalen.pessoa.dto.request.PessoaFisicaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.request.PessoaJuridicaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.response.PessoaResponseDTO;

public interface PessoaService {

	public PessoaResponseDTO salvarPF(PessoaFisicaRequestDTO dto);
	
	public PessoaResponseDTO salvarPJ(PessoaJuridicaRequestDTO dto);
	
	public List<PessoaResponseDTO> listar();
	
	public PessoaResponseDTO buscarPorId(Long id);

}
