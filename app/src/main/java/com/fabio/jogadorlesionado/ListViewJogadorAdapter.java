package com.fabio.jogadorlesionado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fabio.jogadorlesionado.R;
import com.fabio.jogadorlesionado.negocio.Jogador;

import java.util.List;

/**
 * Created by Fabio on 30/08/2015.
 */
public class ListViewJogadorAdapter extends BaseAdapter {
    private Context _context;
    private List<Jogador> lesionados;

    public ListViewJogadorAdapter(Context context, List<Jogador> lesionados){
        this._context = context;
        this.lesionados = lesionados;
    }

    @Override
    public int getCount() {
        return lesionados.size();
    }

    @Override
    public Object getItem(int position) {
        return lesionados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lesionados.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Jogador lesionado = lesionados.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_jogador, null);
        }

        TextView nomeJogador = (TextView) convertView.findViewById(R.id.txvNomeJogador);
        TextView posicao = (TextView) convertView.findViewById(R.id.txvPosicao);
        TextView lesionadoDesde = (TextView) convertView.findViewById(R.id.txvLesionadoDesde);
        ImageView foto = (ImageView) convertView.findViewById(R.id.imgFoto);

        foto.setImageResource(_context.getResources().getIdentifier(
                "com.fabio.jogadorlesionado:drawable/" + lesionado.getFoto(), null, null));
        nomeJogador.setText(lesionado.getNomeGuerra());
        posicao.setText(_context.getResources().getString(
                _context.getResources().getIdentifier(
                        "com.fabio.jogadorlesionado:string/" + lesionado.getPosicao().getStringVal(), null, null)));
        lesionadoDesde.setText(_context.getResources().getString(R.string.injured_since) + " " +
                                lesionado.getLesaoAtual().getDataInicioFormatada() + " " +
                                "(" + lesionado.getLesaoAtual().getTempoLesao() + " dias)");

        return convertView;
    }
}
