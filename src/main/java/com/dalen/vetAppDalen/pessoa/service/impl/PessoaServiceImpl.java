package com.dalen.vetAppDalen.pessoa.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalen.vetAppDalen.pessoa.dto.request.PessoaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.response.PessoaResponseDTO;
import com.dalen.vetAppDalen.pessoa.mapper.PessoaMapper;
import com.dalen.vetAppDalen.pessoa.model.Pessoa;
import com.dalen.vetAppDalen.pessoa.model.PessoaFisica;
import com.dalen.vetAppDalen.pessoa.model.PessoaJuridica;
import com.dalen.vetAppDalen.pessoa.repository.PessoaRepository;
import com.dalen.vetAppDalen.pessoa.service.PessoaService;
import com.dalen.vetAppDalen.shared.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import net.logstash.logback.argument.StructuredArguments;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService{
	
	private static final Logger log = LoggerFactory.getLogger(PessoaServiceImpl.class);

    private final PessoaRepository repository;
    private final PessoaMapper mapper;
    
    @Transactional(readOnly = true)
    @Override
    public Page<PessoaResponseDTO> listar(Pageable pageable) {

        return repository.findAll(pageable)
                .map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public PessoaResponseDTO buscarPorId(Long id) {
    	
    	log.info("Buscando pessoa",
		    StructuredArguments.keyValue("pessoaId", id)
		);
    	
    	Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));

        return mapper.toResponseDTO(pessoa);
    }

    @Transactional
    public PessoaResponseDTO salvar(PessoaRequestDTO dto) {
    	 Pessoa pessoa = mapper.toEntity(dto);
         Pessoa salvo = repository.save(pessoa);
         return mapper.toResponseDTO(salvo);
    }
    
    @Transactional
    public PessoaResponseDTO atualizar(Long id, PessoaRequestDTO dto) {

        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));

        pessoa.setNome(dto.getNome());
        pessoa.setLinkFoto(dto.getLinkFoto());

        if (pessoa instanceof PessoaFisica pf) {
            pf.setCpfCnpj(dto.getCpfCnpj());
        }

        if (pessoa instanceof PessoaJuridica pj) {
            pj.setCpfCnpj(dto.getCpfCnpj());
        }

        return mapper.toResponseDTO(repository.save(pessoa));
    }
    
    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

