package br.edu.ifgoiano.telaschess;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import br.edu.ifgoiano.banco.Dao;
import br.edu.ifgoiano.bin.Competidor;
import br.edu.ifgoiano.bin.DisputaBean;
import br.edu.ifgoiano.bin.GeradorDuplas;
import br.edu.ifgoiano.informatica2015.gmswiss.R;


public class AdicionarNacional extends Activity {

	private ListView listView;
	private EditText campo1;
	private Spinner spinner;
	private String[] estados = { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
			"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará",
			"Paraíba", "Paraná", "Piaui", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia",
			"Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" };

	ArrayList<Competidor> al = new ArrayList<Competidor>();

	public static ArrayList<DisputaBean> db = new ArrayList<DisputaBean>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_adicionar_nacional);

		// ---------------------------------------ListView-------------------------------------//

		listView = (ListView) findViewById(R.id.lista);

		campo1 = (EditText) findViewById(R.id.adversarios);

		// ----------------------------------------SPINNER-------------------------------------//
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, estados);

		this.spinner = (Spinner) findViewById(R.id.spinner);
		this.spinner.setAdapter(adapter);

	}

	private int numero = 0;

	public void adicionarNome(View view) {

		if (campo1.getText().toString().length() > 1) {
			numero++;

			String estado = this.spinner.getSelectedItem().toString();

			Competidor c = new Competidor(numero, campo1.getText() + "", estado);
			al.add(c);
			Dao dao = new Dao(this);
			dao.open();
			dao.inserir(c);
			dao.close();

			@SuppressWarnings({ "unchecked", "rawtypes" })
			ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
			listView.setAdapter(aa);
			this.campo1.getText().clear();

			Intent i = new Intent(this, DisputaNacional.class);
			i.putExtra("Id", numero);
			i.putExtra("Nome", campo1.getText().toString());
		} else {
			Toast.makeText(this, "Nome inválido\n ou Nome vazio", Toast.LENGTH_SHORT).show();
		}

	}

	public void gerarDuplas(View v) {
		if (al.size() < 2) {
			Toast.makeText(this, "Competidores insuficiente", Toast.LENGTH_SHORT).show();
		} else {
			GeradorDuplas gd = new GeradorDuplas(al);
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
	
	public static DisputaBean buscarDisputa(int id){
		for(DisputaBean bean : getDb()){
			if(bean.getId() == id)
				return bean;
		}
		return null;
	}
}