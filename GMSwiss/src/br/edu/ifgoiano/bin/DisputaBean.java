package br.edu.ifgoiano.bin;

public class DisputaBean {

	private int id;
	private String mesa;
	private Competidor a;
	private Competidor b;
	private double pontuacaoCompetidorA;
	private double pontuacaoCompetidorB;
	private int imagem1;
	private int imagem2;

	public DisputaBean() {

	}

	public DisputaBean(int id, Competidor a, double pontuacaoCompetidorA) {

		this.id = id;
		this.a = a;
		this.pontuacaoCompetidorA = pontuacaoCompetidorA;
	}

	public DisputaBean(int id, Competidor b, double pontuacaoCompetidorB,
			String mesa) {
		this.id = id;
		this.b = b;
		this.pontuacaoCompetidorB = pontuacaoCompetidorB;
		this.mesa = mesa;
	}

	public DisputaBean(String mesa, Competidor a, Competidor b,
			double pontuacaoCompetidorA, double pontuacaoCompetidorB) {
		this.mesa = mesa;
		this.a = a;
		this.b = b;
		this.pontuacaoCompetidorA = pontuacaoCompetidorA;
		this.pontuacaoCompetidorB = pontuacaoCompetidorB;
	}

	public DisputaBean(int id, String mesa, Competidor a, Competidor b) {
		this.id = id;
		this.mesa = mesa;
		this.a = a;
		this.b = b;
		this.pontuacaoCompetidorA = 0;
		this.pontuacaoCompetidorB = 0;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public double getPontuacaoCompetidorA() {
		return pontuacaoCompetidorA;
	}

	public void setPontuacaoCompetidorA(double pontuacaoCompetidorA) {
		this.pontuacaoCompetidorA = pontuacaoCompetidorA;
	}

	public double getPontuacaoCompetidorB() {
		return pontuacaoCompetidorB;
	}

	public void setPontuacaoCompetidorB(double pontuacaoCompetidorB) {
		this.pontuacaoCompetidorB = pontuacaoCompetidorB;
	}

	public Competidor getA() {
		return a;
	}

	public void setA(Competidor a) {
		this.a = a;
	}

	public Competidor getB() {
		return b;
	}

	public void setB(Competidor b) {
		this.b = b;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getImagem1() {
		return imagem1;
	}

	public void setImagem1(int imagem1) {
		this.imagem1 = imagem1;
	}

	public int getImagem2() {
		return imagem2;
	}

	public void setImagem2(int imagem2) {
		this.imagem2 = imagem2;
	}

}
