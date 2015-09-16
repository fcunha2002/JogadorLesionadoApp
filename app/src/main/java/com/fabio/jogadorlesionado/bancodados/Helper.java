package com.fabio.jogadorlesionado.bancodados;

/**
 * Created by Fábio Cunha on 10/09/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Locale;

public class Helper extends SQLiteOpenHelper {
    Context _context;

    public Helper(Context context)
    {
        super(context, "jldb", null, 1);
        this._context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //tabelas local
        db.execSQL("CREATE TABLE pais(_id integer PRIMARY KEY NOT NULL, " +
                "nome varchar(40) NOT NULL, bandeira varchar(10) NOT NULL," +
                "controle tinyint(1) NOT NULL DEFAULT '0');");

        db.execSQL("CREATE TABLE clube (_id integer PRIMARY KEY NOT NULL," +
                "nome_completo varchar(80) NOT NULL, nome_reduzido varchar(30) NOT NULL," +
                "escudo varchar(6) NOT NULL, divisao integer NOT NULL, id_pais integer NOT NULL, " +
                "FOREIGN KEY(id_pais) REFERENCES pais(_id));");

        db.execSQL("CREATE TABLE jogador (_id integer PRIMARY KEY NOT NULL, " +
                "nome_completo varchar(80) NOT NULL, nome_guerra varchar(30) NOT NULL, " +
                "foto varchar(6) NOT NULL, posicao varchar(15) NOT NULL, " +
                "data_nascimento date NOT NULL, id_clube integer NOT NULL, id_pais integer NOT NULL, " +
                "FOREIGN KEY(id_clube) REFERENCES clube(_id), FOREIGN KEY(id_pais) REFERENCES pais(_id));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }

    public Context get_context() {
        return _context;
    }

    public void set_context(Context _context) {
        this._context = _context;
    }
}
