package com.dalen.vetAppDalen.pessoa.dto.response;

import lombok.Data;

@Data
public class PessoaResponseDTO {

    private Long id;
    private String nome;
    private String linkFoto;
    private String tipo; // PF ou PJ
}
