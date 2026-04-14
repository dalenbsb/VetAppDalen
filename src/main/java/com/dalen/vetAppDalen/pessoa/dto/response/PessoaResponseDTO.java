package com.dalen.vetAppDalen.pessoa.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaResponseDTO {

    private Long id;
    private String nome;
    private String linkFoto;
    private String tipo; // PF ou PJ
    
    private String cpfCnpj;
}
