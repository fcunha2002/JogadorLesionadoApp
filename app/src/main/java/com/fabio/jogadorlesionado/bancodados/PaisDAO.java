package com.fabio.jogadorlesionado.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.fabio.jogadorlesionado.negocio.Pais;

import java.util.ArrayList;

/**
 * Created by Fábio Cunha on 10/09/2015.
 */
public class PaisDAO {
    private SQLiteDatabase db;
    private String[] columns = {"_id", "nome", "bandeira"};
    private Helper helper;

    public PaisDAO(Context context)
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

    public long insert(Pais pais){
        ContentValues values = new ContentValues();
        values.put("_id", pais.getId());
        values.put("nome", pais.getNome());
        values.put("bandeira", pais.getBandeira());

        long insertId = db.insert("pais", null, values);

        return insertId;
    }

    public ArrayList<Pais> getAll()
    {
        ArrayList<Pais> paises = new ArrayList<Pais>();

        Cursor cursor = db.query("pais", columns, null, null, null, null, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            paises.add(cursorToPais(cursor));
            cursor.moveToNext();
        }

        cursor.close();
        return paises;
    }

    private Pais cursorToPais(Cursor cursor)
    {
        Pais pais = new Pais();

        pais.setId(cursor.getLong(0));
        pais.setNome(cursor.getString(1));
        pais.setBandeira(cursor.getString(2));

        return pais;
    }
}
