package com.fabio.jogadorlesionado.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.fabio.jogadorlesionado.negocio.Clube;
import com.fabio.jogadorlesionado.negocio.Jogador;
import com.fabio.jogadorlesionado.negocio.Lesao;
import com.fabio.jogadorlesionado.negocio.Posicao;
import com.fabio.jogadorlesionado.negocio.TipoLesao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Fábio Cunha on 10/09/2015.
 */
public class LesaoDAO {
    private SQLiteDatabase db;
    private String[] columns = {"_id", "id_jogador", "data_inicio", "data_fim", "tipo", "descricao"};
    private String[] id_column = {"_id"};
    private Helper helper;
    private String TABELA = "lesao";

    public LesaoDAO(Context context)
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

    public long insert(Lesao lesao){
        ContentValues values = new ContentValues();
        values.put("_id", lesao.getId());
        values.put("id_jogador", lesao.getJogador().getId());
        values.put("tipo", lesao.getTipo().name());
        values.put("descricao", lesao.getDescricao());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        values.put("data_inicio", formatter.format(lesao.getDataInicio()));
        if (lesao.getDataFim() != null) {
            values.put("data_fim", formatter.format(lesao.getDataFim()));
        }

        long insertId = db.insert(TABELA, null, values);

        return insertId;
    }

    public long update(Lesao lesao){
        ContentValues values = new ContentValues();
        values.put("id_jogador", lesao.getJogador().getId());
        values.put("tipo", lesao.getTipo().name());
        values.put("descricao", lesao.getDescricao());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        values.put("data_inicio", formatter.format(lesao.getDataInicio()));
        if (lesao.getDataFim() != null) {
            values.put("data_fim", formatter.format(lesao.getDataFim()));
        }

        long updateId = db.update(TABELA, values, "_id=" + lesao.getId(), null);

        return updateId;
    }

    public ArrayList<Lesao> getAll(Jogador jogador)
    {
        ArrayList<Lesao> lesoes = new ArrayList<Lesao>();

        Cursor cursor;
        cursor = db.query(TABELA, columns, "id_jogador=" + jogador.getId(), null, null, null, "data_inicio DESC");

        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            lesoes.add(cursorToLesao(cursor, jogador));
            cursor.moveToNext();
        }

        cursor.close();
        return lesoes;
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

    private Lesao cursorToLesao(Cursor cursor, Jogador jogador)
    {
        Lesao lesao = new Lesao();

        lesao.setId(cursor.getLong(0));
        lesao.setTipo(TipoLesao.valueOf(cursor.getString(4)));

        if (!cursor.getString(5).equals("null")) {
            lesao.setDescricao(cursor.getString(5));
        }else{
            lesao.setDescricao(null);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String data= cursor.getString(2);
            Date d = formatter.parse(data);
            lesao.setDataInicio(d);

            if (cursor.getString(3) != null) {
                data = cursor.getString(3);
                d = formatter.parse(data);
                lesao.setDataFim(d);
            }else{
                lesao.setDataFim(null);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JogadorDAO jogadorDAO = new JogadorDAO(helper.get_context());
        jogadorDAO.openRead();
        lesao.setJogador(jogadorDAO.getById(cursor.getInt(1)));

        return lesao;
    }
}
