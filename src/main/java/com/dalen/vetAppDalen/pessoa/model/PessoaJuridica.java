package com.dalen.vetAppDalen.pessoa.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa{
	
	

}
