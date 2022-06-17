package com.gft.minhaloja.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Livraria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome = "Livraria Moraes";
	private String cnpj = "00.000.000/000-0";
	private double patrimonio;
	
	

	public Livraria(Long id, double patrimonio) {
		this.id = id;
		this.patrimonio = patrimonio;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public String getCnpj() {
		return cnpj;
	}



	public double getPatrimonio() {
		return patrimonio;
	}


	public void setPatrimonio(double patrimonio) {
		this.patrimonio = patrimonio;
	}

	
	
	
}
