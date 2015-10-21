package com.fabio.jogadorlesionado.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Fábio Cunha on 21/10/2015.
 */
public class AtualizacaoDAO {
    private SQLiteDatabase db;
    private String[] columns = {"data"};
    private Helper helper;
    private String TABELA = "atualizacao";

    public AtualizacaoDAO(Context context)
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

    public long update(String data){
        ContentValues values = new ContentValues();
        values.put("data", data);

        long updateId = db.update(TABELA, values, null, null);

        return updateId;
    }

    public String getData(){
        Cursor cursor = db.query(TABELA, columns, null, null, null, null, null);

        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            return cursor.getString(0);
        }else{
            return null;
        }
    }
}
