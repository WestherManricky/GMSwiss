package br.edu.ifgoiano.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import br.edu.ifgoiano.bin.DisputaBean;
import br.edu.ifgoiano.informatica2015.gmswiss.R;

@SuppressLint("ViewHolder")
public class DisputaAdapter extends BaseAdapter {
	private ArrayList<DisputaBean> db;
	
	private HashMap<String, Spinner> mapa;
	
	private Activity activity;

	public DisputaAdapter(Activity activity, ArrayList<DisputaBean> db) {
		this.db = db;
		this.activity = activity;
		this.mapa = new HashMap<String, Spinner>();
	}

	@Override
	public int getCount() {
		return db.size();
	}

	@Override
	public Object getItem(int position) {
		return db.get(position);
	}

	@Override
	public long getItemId(int position) {
		return db.get(position).getId();
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {

		DisputaBean db = (DisputaBean) getItem(position);
		LayoutInflater li = activity.getLayoutInflater();
		View linha = li.inflate(R.layout.item_lista, null);
		
		String[] pontuacao = {"0", "0.5", "1"};
		ArrayAdapter aa = new ArrayAdapter(activity, android.R.layout.simple_list_item_1, pontuacao);
		
		TextView mesa = (TextView) linha.findViewById(R.id.mesa);
		mesa.setText(db.getMesa());

		TextView compA = (TextView) linha.findViewById(R.id.compA);
		compA.setText(db.getA().getNome());

		TextView compB = (TextView) linha.findViewById(R.id.compB);
		compB.setText(db.getB().getNome());

		
		Spinner pontuacaoA = (Spinner) linha.findViewById(R.id.campoPtA);
		pontuacaoA.setTag("S-" + db.getId() + "|" + db.getA().getNumero());
		pontuacaoA.setId(("S-" + db.getId() + "|" + db.getA().getNumero()).hashCode());
		pontuacaoA.setAdapter(aa);
		
		mapa.put("S-" + db.getId() + "|" + db.getA().getNumero(), pontuacaoA);
		
		/*EditText pontuacaoA = (EditText) linha.findViewById(R.id.campoPtA);
		pontuacaoA.setText(db.getPontuacaoCompetidorA() + "");*/

		Spinner pontuacaoB = (Spinner) linha.findViewById(R.id.campoPtB);
		pontuacaoB.setTag("S-" + db.getId() + "|" + db.getB().getNumero());
		pontuacaoB.setId(("S-" + db.getId() + "|" + db.getB().getNumero()).hashCode());
		pontuacaoB.setAdapter(aa);
		
		mapa.put("S-" + db.getId() + "|" + db.getB().getNumero(), pontuacaoB);
		
		/*EditText pontuacaoB = (EditText) linha.findViewById(R.id.campoPtB);
		pontuacaoB.setText(db.getPontuacaoCompetidorB() + "");*/

		ImageView atribuirPtA = (ImageView) linha.findViewById(R.id.scoreA);
		atribuirPtA.setImageResource(R.drawable.ic_shortcut_arrow_back);
		atribuirPtA.setTag("S-" + db.getId() + "|" + db.getA().getNumero());
		
		ImageView atribuirPtB = (ImageView) linha.findViewById(R.id.scoreB);
		atribuirPtB.setImageResource(R.drawable.ic_shortcut_arrow_forward);
		atribuirPtB.setTag("S-" + db.getId() + "|" + db.getB().getNumero());

		return linha;
	}
	
	public int buscarPosicao(double pontuacao){
		String[] lista = activity.getResources().getStringArray(R.array.pontuacao);
		int posicao = 0;
		for(int i = 0; i < lista.length; i++){
			if(lista[i].equals(pontuacao + ""))
				return posicao;
			posicao++;
		}
		return 0;
	}

	public HashMap<String, Spinner> getMapa() {
		return mapa;
	}
	
}
