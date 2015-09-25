package com.fabio.jogadorlesionado.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.fabio.jogadorlesionado.negocio.Clube;
import com.fabio.jogadorlesionado.negocio.Pais;

import java.util.ArrayList;

/**
 * Created by Fábio Cunha on 10/09/2015.
 */
public class ClubeDAO {
    private SQLiteDatabase db;
    private String[] columns = {"_id", "nome_completo", "nome_reduzido", "escudo", "divisao"};
    private Helper helper;
    private String TABELA = "clube";

    public ClubeDAO(Context context)
    {
        helper = new Helper(context);
    }

    public void openWrite() throws SQLException
    {
        db = helper.getWritableDatabase();
    }

    public void openRead() throws SQLException
    {
        db = helper.getReadableDatabase();
    }

    public void close()
    {
        db.close();
    }

    public long insert(Clube clube){
        ContentValues values = new ContentValues();
        values.put("_id", clube.getId());
        values.put("nome_completo", clube.getNomeCompleto());
        values.put("nome_reduzido", clube.getNomeReduzido());
        values.put("escudo", clube.getEscudo());
        values.put("divisao", clube.getDivisao());
        values.put("id_pais", clube.getPais().getId());

        long insertId = db.insert(TABELA, null, values);

        return insertId;
    }

    public long update(Clube clube){
        ContentValues values = new ContentValues();
        values.put("nome_completo", clube.getNomeCompleto());
        values.put("nome_reduzido", clube.getNomeReduzido());
        values.put("escudo", clube.getEscudo());
        values.put("divisao", clube.getDivisao());

        long updateId = db.update(TABELA, values, "_id=" + clube.getId(), null);

        return updateId;
    }

    public ArrayList<Clube> getAll(Pais pais)
    {
        ArrayList<Clube> clubes = new ArrayList<Clube>();

        Cursor cursor;
        cursor = db.query(TABELA, columns, "id_pais=" + pais.getId(), null, null, null, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            clubes.add(cursorToClube(cursor, pais));
            cursor.moveToNext();
        }

        cursor.close();

        JogadorDAO jogadorDAO = new JogadorDAO(helper.get_context());
        jogadorDAO.openRead();
        for (Clube clube : clubes) {
            clube.getLesionados().addAll(jogadorDAO.getAllInjuried(clube));
        }
        jogadorDAO.close();

        return clubes;
    }

    public boolean exists(long id){
        Cursor cursor = db.query(TABELA, columns, "_id=" + id, null, null, null, null);

        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.close();
            return true;
        }else{
            cursor.close();
            return false;
        }
    }

    private Clube cursorToClube(Cursor cursor, Pais pais)
    {
        Clube clube = new Clube();

        clube.setId(cursor.getLong(0));
        clube.setNomeCompleto(cursor.getString(1));
        clube.setNomeReduzido(cursor.getString(2));
        clube.setEscudo(cursor.getString(3));
        clube.setDivisao(cursor.getInt(4));
        clube.setPais(pais);

        return clube;
    }
}
