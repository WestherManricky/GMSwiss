package br.edu.ifgoiano.bin;

import java.io.Serializable;

public class Duplas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome1;
	private String nome2;

	public Duplas(String nome1, String nome2)  {
		super();
		this.nome1 = nome1;
		this.nome2 = nome2;
	}

	public String getNome1() {
		return nome1;
	}

	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}

	public String getNome2() {
		return nome2;
	}

	public void setNome2(String nome2) {
		this.nome2 = nome2;
	}
	
	public String toString() {
		return this.nome1 + " x " + this.nome2;
	}

}
