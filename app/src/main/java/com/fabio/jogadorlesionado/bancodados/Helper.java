package com.fabio.jogadorlesionado.bancodados;

/**
 * Created by Fábio Cunha on 10/09/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {
    public Helper(Context context)
    {
        super(context, "jldb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //tabelas local
        db.execSQL("CREATE TABLE pais(_id Integer PRIMARY KEY NOT NULL, " +
                "nome varchar(40) NOT NULL, bandeira varchar(10) NOT NULL);");

//        db.execSQL("CREATE TABLE Contato_Local(_id Integer PRIMARY KEY NOT NULL, " +
//                "nick varchar(20) NOT NULL, email varchar(70) NOT NULL);");
//
//        db.execSQL("CREATE TABLE Mensagem_Local(_id Integer PRIMARY KEY NOT NULL, texto varchar(160) NOT NULL, data DATE NOT NULL, hora TIME NOT NULL," +
//                "_id_sender Integer NOT NULL, _id_target Long NOT NULL, FOREIGN KEY(_id_sender) REFERENCES Usuario_Local(_id), " +
//                "FOREIGN KEY(_id_target) REFERENCES Contato(_id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }
}
