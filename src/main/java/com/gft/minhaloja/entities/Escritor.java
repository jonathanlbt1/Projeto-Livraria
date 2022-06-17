package com.gft.minhaloja.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Escritor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	

	public Escritor() {
	}

	public Escritor(String nomeString) {
		this.nome = nomeString;
	}

	public Long getIdLong() {
		return id;
	}

	public void setIdLong(Long idLong) {
		this.id = idLong;
	}

	public String getNomeString() {
		return nome;
	}

	public void setNomeString(String nomeString) {
		this.nome = nomeString;
	}

	
}
