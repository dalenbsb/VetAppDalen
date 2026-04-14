package com.dalen.vetAppDalen.pessoa.mapper;

import org.springframework.stereotype.Component;

import com.dalen.vetAppDalen.pessoa.dto.request.PessoaRequestDTO;
import com.dalen.vetAppDalen.pessoa.dto.response.PessoaResponseDTO;
import com.dalen.vetAppDalen.pessoa.model.Pessoa;
import com.dalen.vetAppDalen.pessoa.model.PessoaFisica;
import com.dalen.vetAppDalen.pessoa.model.PessoaJuridica;



@Component
public class PessoaMapper {

    public Pessoa toEntity(PessoaRequestDTO dto) {

        if ("PF".equalsIgnoreCase(dto.getTipo())) {
            PessoaFisica pf = new PessoaFisica();
            pf.setNome(dto.getNome());
            pf.setLinkFoto(dto.getLinkFoto());
            pf.setCpfCnpj(dto.getCpfCnpj());
            return pf;
        }

        if ("PJ".equalsIgnoreCase(dto.getTipo())) {
            PessoaJuridica pj = new PessoaJuridica();
            pj.setNome(dto.getNome());
            pj.setLinkFoto(dto.getLinkFoto());
            pj.setCpfCnpj(dto.getCpfCnpj());
            return pj;
        }

        throw new RuntimeException("Tipo inválido");
    }

    public PessoaResponseDTO toResponseDTO(Pessoa pessoa) {

        PessoaResponseDTO.PessoaResponseDTOBuilder builder = PessoaResponseDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .linkFoto(pessoa.getLinkFoto());

        if (pessoa instanceof PessoaFisica pf) {
            builder.tipo("PF").cpfCnpj(pf.getCpfCnpj());
        }

        if (pessoa instanceof PessoaJuridica pj) {
            builder.tipo("PJ").cpfCnpj(pj.getCpfCnpj());
        }

        return builder.build();
    }
    
}
