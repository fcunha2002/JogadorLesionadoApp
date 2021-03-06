package com.fabio.jogadorlesionado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fabio.jogadorlesionado.bancodados.ClubeDAO;
import com.fabio.jogadorlesionado.negocio.Clube;
import com.fabio.jogadorlesionado.negocio.Pais;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabio on 05/06/2015.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<Pais> _listaPaises = new ArrayList<Pais>();

    public ExpandableListAdapter(Context context, List<Pais> listaPaises) {
        this._context = context;
        this._listaPaises = listaPaises;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parentView) {
        final Pais pais = _listaPaises.get(groupPosition);

        if (pais.getClubes().size() == 0){
            ClubeDAO clubeDAO = new ClubeDAO(_context);
            clubeDAO.openRead();
            pais.getClubes().addAll(clubeDAO.getAll(pais));
            clubeDAO.close();
        }

        if (convertView == null) {
            LayoutInflater inflaInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflaInflater.inflate(R.layout.layout_pais, parentView, false);
        }

        ((TextView) convertView.findViewById(R.id.txvNomePais)).setText(
                _context.getResources().getString(
                        _context.getResources().getIdentifier(
                                "com.fabio.jogadorlesionado:string/" + pais.getNome(), null, null)));

        ((TextView) convertView.findViewById(R.id.txvTotalLesionadosPais)).setText("(" + pais.getTotalLesionados() + ")");

        ImageView image=(ImageView)convertView.findViewById(R.id.imgBandeira);

        image.setImageResource(_context.getResources().getIdentifier(
                        "com.fabio.jogadorlesionado:drawable/"+pais.getBandeira(),null,null));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final Clube clube = (Clube) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflaInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflaInflater.inflate(R.layout.layout_clube, null);
        }

        TextView txvNomeClube = (TextView) convertView.findViewById(R.id.txvNomeClube);
        TextView txvTotalLesionados = (TextView) convertView.findViewById(R.id.txvTotalLesionados);

        ImageView image=(ImageView)convertView.findViewById(R.id.imgEscudo);

        image.setImageResource(_context.getResources().getIdentifier(
                "com.fabio.jogadorlesionado:drawable/"+clube.getEscudo(),null,null));

        txvNomeClube.setText(clube.getNomeReduzido());
        txvTotalLesionados.setText(clube.getLesionados().size() + " " + _context.getResources().getString(R.string.qtd_injured));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public int getGroupCount() {
        return this._listaPaises.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listaPaises.get(groupPosition).getClubes().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listaPaises.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listaPaises.get(groupPosition).getClubes().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return this._listaPaises.get(groupPosition).getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return this._listaPaises.get(groupPosition).getClubes().get(childPosition).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


}
