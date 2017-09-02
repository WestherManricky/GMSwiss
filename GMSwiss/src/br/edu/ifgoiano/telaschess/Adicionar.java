package br.edu.ifgoiano.telaschess;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import br.edu.ifgoiano.banco.Dao;
import br.edu.ifgoiano.bin.Competidor;
import br.edu.ifgoiano.bin.DisputaBean;
import br.edu.ifgoiano.bin.GeradorDuplas;
import br.edu.ifgoiano.informatica2015.gmswiss.R;

public class Adicionar extends Activity implements OnItemClickListener, OnItemLongClickListener {
	private ArrayList<Competidor> arrayList = new ArrayList<Competidor>();
	private ListView listView;
	private EditText campoNome;
	@SuppressWarnings("unused")
	private Competidor competidor;

	public static ArrayList<DisputaBean> db = new ArrayList<DisputaBean>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_adicionar);
		campoNome = (EditText) findViewById(R.id.adversarios);

		listView = (ListView) findViewById(R.id.lista);

	}

	private int numero = 0;

	public void adicionarNome(View view) {

		if (campoNome.getText().toString().length() > 1) {
			numero++;

			Competidor c = new Competidor(numero, campoNome.getText() + "");
			arrayList.add(c);

			Dao dao = new Dao(this);
			dao.open();
			dao.inserir(c);
			dao.close();

			@SuppressWarnings({ "unchecked", "rawtypes" })
			ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
			listView.setAdapter(aa);
			this.campoNome.getText().clear();
		} else {
			Toast.makeText(this, "Nome inválido\n ou Nome vazio", Toast.LENGTH_SHORT).show();
		}

	}

	public void gerarDuplas(View v) {
		if (arrayList.size() < 2) {
			Toast.makeText(this, "Competidores insuficiente", Toast.LENGTH_SHORT).show();
		} else {
			GeradorDuplas gd = new GeradorDuplas(arrayList);
			gd.run();

			setDb(gd.getSorteio());
			Intent i = new Intent(this, DisputaNacional.class);

			startActivity(i);
			finish();
		}
	}

	public static ArrayList<DisputaBean> getDb() {
		return db;
	}

	public static void setDb(ArrayList<DisputaBean> db) {
		AdicionarNacional.db = db;
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		this.competidor = (Competidor) parent.getItemAtPosition(position);
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	}

}