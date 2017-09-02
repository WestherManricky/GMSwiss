package br.edu.ifgoiano.telaschess;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.Spinner;
import br.edu.ifgoiano.adapter.DisputaAdapter;
import br.edu.ifgoiano.banco.Dao;
import br.edu.ifgoiano.bin.Competidor;
import br.edu.ifgoiano.bin.DisputaBean;
import br.edu.ifgoiano.informatica2015.gmswiss.R;

public class DisputaNacional extends Activity {

	// private TextView pa;
	// private Spinner compA, compB;
	private ListView listaDisputa;

	private DisputaAdapter da;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_disputa_nacional);

		da = new DisputaAdapter(this, AdicionarNacional.getDb());

		listaDisputa = (ListView) findViewById(R.id.listaDisputa);
		listaDisputa.setAdapter(da);

	}

	public void pegarValor(View view) {

		Dao dao = new Dao(this);
		dao.open();
		dao.close();

	}

	public String getSpinnerValue(String id) {
		HashMap<String, Spinner> mapa = da.getMapa();
		Spinner s = mapa.get(id);
		return ((Spinner) findViewById(s.getId())).getSelectedItem() + "";
	}

	public void atribuir(View view) {

		String value = getSpinnerValue(view.getTag().toString());
		String tagButton = view.getTag().toString();

		String idDisputa = tagButton.substring(tagButton.indexOf("-") + 1,
				tagButton.indexOf("|"));

		DisputaBean disputa = AdicionarNacional.buscarDisputa(Integer
				.parseInt(idDisputa));
		Competidor comA = disputa.getA();

		Competidor comB = disputa.getB();
		String mesa = disputa.getMesa();
		DisputaBean db = new DisputaBean(mesa, comA, comB,
				Double.parseDouble(value), Double.parseDouble(value));

		// 0Log.i("Script", comA.getNome() + " - " + comB.getNome());

		Dao dao = new Dao(this);

		dao.open();
		dao.inserir(db);
		dao.close();

	}

}
