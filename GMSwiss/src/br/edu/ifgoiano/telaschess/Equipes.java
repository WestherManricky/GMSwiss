package br.edu.ifgoiano.telaschess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import br.edu.ifgoiano.informatica2015.gmswiss.R;

public class Equipes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_equipes);
	}

	public void adicionar(View v) {
		Intent i = new Intent(this, AdicionarNacional.class);
		startActivity(i);
	}
}
