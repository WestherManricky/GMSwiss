package br.edu.ifgoiano.telaschess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import br.edu.ifgoiano.informatica2015.gmswiss.R;


public class Niveis extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_niveis);
		
	}

	public void interno(View view) {
		Intent i = new Intent(this, Interno.class);
		startActivity(i);
	}

	public void genero(View view) {
		Intent i = new Intent(this, Generos.class);
		startActivity(i);
	}

	public void equipe(View view) {
		Intent i = new Intent(this, Equipes.class);
		startActivity(i);

	}
}