package com.fabio.jogadorlesionado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fabio.jogadorlesionado.negocio.Jogador;
import com.fabio.jogadorlesionado.negocio.Lesao;

import java.util.List;

/**
 * Created by Fabio on 30/08/2015.
 */
public class ListViewHistLesaoAdapter extends BaseAdapter {
    private Context _context;
    private List<Lesao> lesoes;

    public ListViewHistLesaoAdapter(Context context, List<Lesao> lesoes){
        this._context = context;
        this.lesoes = lesoes;
    }

    @Override
    public int getCount() {
        return lesoes.size();
    }

    @Override
    public Object getItem(int position) {
        return lesoes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lesoes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Lesao lesao = lesoes.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_hist_lesao, null);
        }

        TextView tipoLesao = (TextView) convertView.findViewById(R.id.txvTipoLesao);
        TextView descricao = (TextView) convertView.findViewById(R.id.txvDescricao);
        TextView periodo = (TextView) convertView.findViewById(R.id.txvPeriodo);
        TextView afastamento = (TextView) convertView.findViewById(R.id.txvAfastamento);

        tipoLesao.setText(_context.getResources().getString(
                _context.getResources().getIdentifier(
                        "com.fabio.jogadorlesionado:string/" + lesao.getTipo().getStringVal(), null, null)));

        descricao.setText(lesao.getDescricao());
        periodo.setText(lesao.getDataInicioFormatada());
        afastamento.setText(lesao.getTempoLesao() + " " +
                            " dias lesionado");

        return convertView;
    }
}
