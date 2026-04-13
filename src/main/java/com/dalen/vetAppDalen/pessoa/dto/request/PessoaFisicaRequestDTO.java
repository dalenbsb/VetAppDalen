package com.dalen.vetAppDalen.pessoa.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PessoaFisicaRequestDTO extends PessoaRequestDTO {

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
}