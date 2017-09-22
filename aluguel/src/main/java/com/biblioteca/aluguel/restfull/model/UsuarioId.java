package com.biblioteca.aluguel.restfull.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UsuarioId implements Serializable {
	
	private Long cpf;
	private Long rg;
	
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public Long getRg() {
		return rg;
	}
	public void setRg(Long rg) {
		this.rg = rg;
	}
	
	

}
