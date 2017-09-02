package br.edu.ifgoiano.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoChess extends SQLiteOpenHelper {

	private static final String NOME_BANCO = "banco";
	private static final int VERSAO = 5;

	public BancoChess(Context context) {
		super(context, NOME_BANCO, null, VERSAO);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String tabelaCompetidor = "CREATE TABLE competidor ("
				+ " id INTEGER PRIMARY KEY AUTOINCREMENT," + " nome TEXT);";
		db.execSQL(tabelaCompetidor);

		String tabelaDisputaBean = "CREATE TABLE disputaBean ("
				+ " id INTEGER PRIMARY KEY AUTOINCREMENT," + " mesa TEXT,"
				+ " competidorA TEXT," + " competidorB TEXT,"
				+ " pontuacaoA REAL," + " pontuacaoB);";
		db.execSQL(tabelaDisputaBean);

		String tabelaEquipe = "CREATE TABLE competidorEquipe ("
				+ " id INTEGER PRIMARY KEY AUTOINCREMENT," + " nome TEXT,"
				+ " score REAL," + " estado TEXT);";
		db.execSQL(tabelaEquipe);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS competidor");
		db.execSQL("DROP TABLE IF EXISTS disputaBean");
		db.execSQL("DROP TABLE IF EXISTS competidorEquipe");
		onCreate(db);
	}

}
