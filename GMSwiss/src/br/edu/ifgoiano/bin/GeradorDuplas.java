package br.edu.ifgoiano.bin;

import java.util.ArrayList;

public class GeradorDuplas {

	private ArrayList<Competidor> al;
	private ArrayList<DisputaBean> sorteio;

	public GeradorDuplas(ArrayList<Competidor> al) {
		this.al = al;
	}

	public void run() {
		ArrayList<Competidor> copy = al;
		sorteio = new ArrayList<DisputaBean>();

		int count = copy.size();
		if (count % 2 != 0)
			copy.add(new Competidor(0, "BYE", "-"));

		int nMesa = 1;
		while (count >= 2) {
			int aleatorio = (int) (Math.random() * count - 1);
			Competidor compA = copy.get(aleatorio);
			copy.remove(aleatorio);
			count = copy.size();
			aleatorio = (int) (Math.random() * count - 1);
			Competidor compB = copy.get(aleatorio);
			copy.remove(aleatorio);
			count = copy.size();

			DisputaBean db = new DisputaBean(nMesa, ("Mesa " + nMesa), compA,
					compB);

			nMesa++;

			sorteio.add(db);
		}

	}

	public ArrayList<DisputaBean> getSorteio() {
		return this.sorteio;
	}

}
