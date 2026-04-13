package com.dalen.vetAppDalen.pessoa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalen.vetAppDalen.pessoa.dto.request.PessoaFisicaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.request.PessoaJuridicaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.response.PessoaResponseDTO;
import com.dalen.vetAppDalen.pessoa.service.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {
	
	private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping("/pf")
    public PessoaResponseDTO criarPF(@RequestBody @Valid PessoaFisicaRequestDTO dto) {
        return service.salvarPF(dto);
    }

    @PostMapping("/pj")
    public PessoaResponseDTO criarPJ(@RequestBody @Valid PessoaJuridicaRequestDTO dto) {
        return service.salvarPJ(dto);
    }

    @GetMapping
    public List<PessoaResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PessoaResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}