package br.edu.ifgoiano.bin;

public class Competidor {

	private int numero;
	private String nome;
	private String uf;

	public Competidor(int numero, String nome, String uf) {
		this.numero = numero;
		this.nome = nome;
		this.uf = uf;
	}

	public Competidor(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}

	public Competidor() {

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		if (uf == null) {
			return numero + " - " + nome;
		} else {
			return numero + " - " + nome + " - " + uf;
		}
	}

}
