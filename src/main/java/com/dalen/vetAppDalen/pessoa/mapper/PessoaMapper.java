package com.dalen.vetAppDalen.pessoa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dalen.vetAppDalen.pessoa.dto.request.PessoaFisicaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.request.PessoaJuridicaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.response.PessoaFisicaResponseDTO;
import com.dalen.vetAppDalen.pessoa.dto.response.PessoaJuridicaResponseDTO;
import com.dalen.vetAppDalen.pessoa.model.PessoaFisica;
import com.dalen.vetAppDalen.pessoa.model.PessoaJuridica;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
	 // REQUEST → ENTITY
    PessoaFisica toEntity(PessoaFisicaRequestDTO dto);
    
    PessoaJuridica toEntity(PessoaJuridicaRequestDTO dto);

    // ENTITY → RESPONSE
    @Mapping(target = "tipo", constant = "PF")
    PessoaFisicaResponseDTO toDTO(PessoaFisica entity);

    @Mapping(target = "tipo", constant = "PJ")
    PessoaJuridicaResponseDTO toDTO(PessoaJuridica entity);
}
