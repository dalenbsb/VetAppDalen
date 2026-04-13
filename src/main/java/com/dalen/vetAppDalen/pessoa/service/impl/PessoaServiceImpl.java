package com.dalen.vetAppDalen.pessoa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalen.vetAppDalen.pessoa.dto.request.PessoaFisicaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.request.PessoaJuridicaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.response.PessoaResponseDTO;
import com.dalen.vetAppDalen.pessoa.mapper.PessoaMapper;
import com.dalen.vetAppDalen.pessoa.model.Pessoa;
import com.dalen.vetAppDalen.pessoa.model.PessoaFisica;
import com.dalen.vetAppDalen.pessoa.model.PessoaJuridica;
import com.dalen.vetAppDalen.pessoa.repository.PessoaRepository;
import com.dalen.vetAppDalen.pessoa.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{

    private final PessoaRepository repository;
    private final PessoaMapper mapper;

    public PessoaServiceImpl(PessoaRepository repository, PessoaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public PessoaResponseDTO salvarPF(PessoaFisicaRequestDTO dto) {
        PessoaFisica entity = mapper.toEntity(dto);
        return mapper.toDTO((PessoaFisica) repository.save(entity));
    }

    @Transactional
    public PessoaResponseDTO salvarPJ(PessoaJuridicaRequestDTO dto) {
        PessoaJuridica entity = mapper.toEntity(dto);
        return mapper.toDTO((PessoaJuridica) repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<PessoaResponseDTO> listar() {
        return repository.findAll().stream().map(pessoa -> {
            if (pessoa instanceof PessoaFisica pf) {
                return mapper.toDTO(pf);
            } else if (pessoa instanceof PessoaJuridica pj) {
                return mapper.toDTO(pj);
            }
            throw new RuntimeException("Tipo desconhecido");
        }).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PessoaResponseDTO buscarPorId(Long id) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        if (pessoa instanceof PessoaFisica pf) {
            return mapper.toDTO(pf);
        } else if (pessoa instanceof PessoaJuridica pj) {
            return mapper.toDTO(pj);
        }

        throw new RuntimeException("Tipo desconhecido");
    }
}

