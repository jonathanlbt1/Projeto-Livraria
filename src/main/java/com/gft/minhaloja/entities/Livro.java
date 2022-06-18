package com.gft.minhaloja.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String escritor;
	private String genero;
	private Integer quantitade;
	private Double preco;
	
	
	public Livro() {
	}


	public Livro(Long id, String nome, String escritor, String genero, Integer quantitade, Double preco) {
		this.id = id;
		this.nome = nome;
		this.escritor = escritor;
		this.genero = genero;
		this.quantitade = quantitade;
		this.preco = preco;
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


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEscritor() {
		return escritor;
	}


	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Integer getQuantitade() {
		return quantitade;
	}


	public void setQuantitade(Integer quantitade) {
		this.quantitade = quantitade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}



}
