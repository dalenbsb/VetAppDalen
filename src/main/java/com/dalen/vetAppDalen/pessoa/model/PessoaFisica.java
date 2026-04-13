package com.dalen.vetAppDalen.pessoa.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {

	private String cpf;
}
