package br.edu.ifgoiano.telaschess;

import br.edu.ifgoiano.adapter.DisputaAdapter;
import br.edu.ifgoiano.informatica2015.gmswiss.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

public class Disputa extends Activity {
	private ListView listaDisputa;

	// private TextView um, dois;
	// private Spinner spinner;
	//
	// private String[] pontos = { "0", "1/2", "1" };

	/**
	 * Aqui é necessário adicionar um spinner para substituir o EditText no qual
	 * tem a função de atribuir a pontuação para os competidores. Porém, não
	 * estamos conseguindo gerar os Spinners juntamente com as mesas.
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_disputa_nacional);

		DisputaAdapter da = new DisputaAdapter(this, AdicionarNacional.getDb());
		listaDisputa = (ListView) findViewById(R.id.listaDisputa);
		listaDisputa.setAdapter(da);

		/**
		 * Aqui também é necessário fazer a comparação das pontuações dos
		 * competidores, se forem iguais, gerar duplas entres elas. Outro ponto
		 * que travamos.
		 */

	}
}