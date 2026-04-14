package com.dalen.vetAppDalen.pessoa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dalen.vetAppDalen.pessoa.dto.request.PessoaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.response.PessoaResponseDTO;

public interface PessoaService {
	
	public Page<PessoaResponseDTO> listar(Pageable pageable);
	
	public PessoaResponseDTO buscarPorId(Long id);
	
	 public PessoaResponseDTO salvar(PessoaRequestDTO dto);
	
	public PessoaResponseDTO atualizar(Long id, PessoaRequestDTO dto);
	
	public void deletar(Long id);

}
