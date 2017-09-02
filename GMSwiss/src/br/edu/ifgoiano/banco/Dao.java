package br.edu.ifgoiano.banco;

import java.util.ArrayList;

import br.edu.ifgoiano.bin.Competidor;
import br.edu.ifgoiano.bin.DisputaBean;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Dao {

	private SQLiteDatabase sqlDatabase;
	private BancoChess database;

	private String[] colunas = { "id", "nome" };

	private String[] colunasBean = { "id", "mesa", "competidorA",
			"competidorB", "pontuacaoA", "pontuacaoB" };

	private String[] colunasEquipe = { "id", "nome", "score", "estado" };

	public Dao(Context context) {

		database = new BancoChess(context);

	}

	public void open() throws SQLException {
		sqlDatabase = database.getWritableDatabase();
	}

	public void close() {
		database.close();

	}

	public ArrayList<Competidor> buscar() {
		ArrayList<Competidor> lista = new ArrayList<Competidor>();

		Cursor cursor = sqlDatabase.query("competidor", colunas,
				"nome LIKE '%", null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Competidor c = toValor(cursor);
			lista.add(c);
			cursor.moveToNext();
		}
		cursor.close();
		return lista;
	}

	public void inserir(Competidor competidor) {
		ContentValues values = new ContentValues();
		values.put(colunas[1], competidor.getNome());

		sqlDatabase.insert("competidor", null, values);
	}

	public void inserir(DisputaBean db) {
		ContentValues values = new ContentValues();
		values.put(colunasBean[1], db.getMesa());
		values.put(colunasBean[2], db.getA().toString());
		values.put(colunasBean[3], db.getB().toString());
		values.put(colunasBean[4], db.getPontuacaoCompetidorA());
		values.put(colunasBean[5], db.getPontuacaoCompetidorB());

		sqlDatabase.insert("disputaBean", null, values);
	}

	public void inserirEquipe(Competidor competidor) {
		ContentValues a = new ContentValues();
		a.put(colunasEquipe[1], competidor.getNome());
		a.put(colunasEquipe[2], competidor.getUf());
		sqlDatabase.insert("competidorEquipe", null, a);
	}

	public Competidor toValor(Cursor cursor) {
		Competidor c = new Competidor();
		c.setNumero(cursor.getInt(0));
		c.setNome(cursor.getString(1));
		return c;
	}

	public Competidor toValor2(Cursor cursor) {
		Competidor c = new Competidor();
		c.setNumero(cursor.getInt(0));
		c.setNome(cursor.getString(1));
		c.setUf(cursor.getString(2));
		return c;
	}

	public DisputaBean toValor3(Cursor cursor) {
		DisputaBean c = new DisputaBean();
		c.setMesa(cursor.getString(0));
		c.setA(c.getA());
		c.setB(c.getB());
		c.setPontuacaoCompetidorA(cursor.getDouble(3));
		c.setPontuacaoCompetidorB(cursor.getDouble(4));
		return c;
	}
}
