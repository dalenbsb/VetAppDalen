package com.dalen.vetAppDalen.pessoa.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PessoaRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100)
    private String nome;
    private String linkFoto;
    private String tipo; // PF ou PJ
    
    private String cpfCnpj;
}
