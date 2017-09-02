package br.edu.ifgoiano.bin;

public class Valores {

	private int id;
	private String nome;
	private double score;
	private String estado;

	public Valores(int id, String nome, double score, String estado) {
		this.id = id;
		this.nome = nome;
		this.score = score;
		this.estado = estado;
	}

	public Valores() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valores other = (Valores) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Valores [id=" + id + ", nome=" + nome + ", score=" + score
				+ ", estado=" + estado + "]";
	}

}
