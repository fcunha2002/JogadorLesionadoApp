package com.fabio.jogadorlesionado.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.fabio.jogadorlesionado.negocio.Clube;
import com.fabio.jogadorlesionado.negocio.Jogador;
import com.fabio.jogadorlesionado.negocio.Pais;
import com.fabio.jogadorlesionado.negocio.Posicao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/**
 * Created by Fábio Cunha on 10/09/2015.
 */
public class JogadorDAO {
    private SQLiteDatabase db;
    private String[] columns = {"_id", "nome_completo", "nome_guerra", "foto", "posicao", "data_nascimento", "id_pais"};
    private String[] id_column = {"_id"};
    private Helper helper;
    private String TABELA = "jogador";

    public JogadorDAO(Context context)
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

    public long insert(Jogador jogador){
        ContentValues values = new ContentValues();
        values.put("_id", jogador.getId());
        values.put("nome_completo", jogador.getNomeCompleto());
        values.put("nome_guerra", jogador.getNomeGuerra());
        values.put("foto", jogador.getFoto());
        values.put("posicao", jogador.getPosicao().name());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        values.put("data_nascimento", formatter.format(jogador.getDataNascimento()));

        values.put("id_clube", jogador.getClube().getId());
        values.put("id_pais", jogador.getPais().getId());

        long insertId = db.insert(TABELA, null, values);

        return insertId;
    }

    public long update(Jogador jogador){
        ContentValues values = new ContentValues();
        values.put("nome_completo", jogador.getNomeCompleto());
        values.put("nome_guerra", jogador.getNomeGuerra());
        values.put("foto", jogador.getFoto());
        values.put("posicao", jogador.getPosicao().name());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        values.put("data_nascimento", formatter.format(jogador.getDataNascimento()));

        values.put("id_clube", jogador.getClube().getId());
        values.put("id_pais", jogador.getPais().getId());

        long updateId = db.update(TABELA, values, "_id=" + jogador.getId(), null);

        return updateId;
    }

    public ArrayList<Jogador> getAll(Clube clube)
    {
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

        Cursor cursor;
        cursor = db.query(TABELA, columns, "id_clube=" + clube.getId(), null, null, null, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            jogadores.add(cursorToJogador(cursor, clube));
            cursor.moveToNext();
        }

        cursor.close();
        return jogadores;
    }

    public boolean exists(long id){
        Cursor cursor = db.query(TABELA, id_column, "_id=" + id, null, null, null, null);

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

    public Jogador getById(long id){
        Cursor cursor = db.query(TABELA, columns, "_id=" + id, null, null, null, null);

        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            return cursorToJogador(cursor, null);
        }else{
            return null;
        }
    }

    private Jogador cursorToJogador(Cursor cursor, Clube clube)
    {
        Jogador jogador = new Jogador();

        jogador.setId(cursor.getLong(0));
        jogador.setNomeCompleto(cursor.getString(1));
        jogador.setNomeGuerra(cursor.getString(2));
        jogador.setFoto(cursor.getString(3));
        jogador.setPosicao(Posicao.valueOf(cursor.getString(4)));

        String data= cursor.getString(5);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = formatter.parse(data);
            jogador.setDataNascimento(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jogador.setClube(clube);

        PaisDAO paisDAO = new PaisDAO(helper.get_context());
        paisDAO.openRead();
        jogador.setPais(paisDAO.getById(cursor.getInt(6)));

        return jogador;
    }
}
