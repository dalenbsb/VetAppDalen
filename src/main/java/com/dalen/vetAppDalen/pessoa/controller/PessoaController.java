package com.dalen.vetAppDalen.pessoa.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalen.vetAppDalen.pessoa.dto.request.PessoaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.response.PessoaResponseDTO;
import com.dalen.vetAppDalen.pessoa.service.PessoaService;
import com.dalen.vetAppDalen.shared.mapper.PageMapper;
import com.dalen.vetAppDalen.shared.response.ApiResponse;
import com.dalen.vetAppDalen.shared.response.PageResponse;
import com.dalen.vetAppDalen.shared.util.ResponseUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/pessoas")
@RequiredArgsConstructor
public class PessoaController {
	
	private final PessoaService service;

	@PostMapping
    public ResponseEntity<ApiResponse<PessoaResponseDTO>> salvar(@RequestBody @Valid PessoaRequestDTO dto) {
		PessoaResponseDTO respDto = service.salvar(dto);
		
		return ResponseEntity.ok(ResponseUtils.success(respDto));
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PessoaResponseDTO>> buscar(@PathVariable Long id) {
		PessoaResponseDTO dto = service.buscarPorId(id);

	    return ResponseEntity.ok(ResponseUtils.success(dto));
    }

	@GetMapping
	public ResponseEntity<ApiResponse<PageResponse<PessoaResponseDTO>>> listar(Pageable pageable) {

	    Page<PessoaResponseDTO> page = service.listar(pageable);

	    return ResponseEntity.ok(
	            ResponseUtils.success(PageMapper.map(page))
	    );
	}
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PessoaResponseDTO>> atualizar(@PathVariable Long id,
                                       @RequestBody PessoaRequestDTO dto) {
    	PessoaResponseDTO respDto = service.atualizar(id, dto);
    	
    	return ResponseEntity.ok(ResponseUtils.success(respDto));
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    
}