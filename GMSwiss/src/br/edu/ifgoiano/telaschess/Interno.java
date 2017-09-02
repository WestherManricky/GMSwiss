package br.edu.ifgoiano.telaschess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import br.edu.ifgoiano.informatica2015.gmswiss.R;

public class Interno extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_interno);
	}
	public void genero(View view){
			
		Intent i = new Intent(this, Generos.class);
		startActivity(i);
	}
	public void MeF(View c){
		Intent i = new Intent(this, Adicionar.class);
		startActivity(i);
		
	}
}
