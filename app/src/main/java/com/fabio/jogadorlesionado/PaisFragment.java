package com.fabio.jogadorlesionado;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.fabio.jogadorlesionado.negocio.Clube;
import com.fabio.jogadorlesionado.negocio.Contrato;
import com.fabio.jogadorlesionado.negocio.Jogador;
import com.fabio.jogadorlesionado.negocio.Pais;
import com.fabio.jogadorlesionado.negocio.Test;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PaisFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<Pais> paises;

    private AdView adView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View activity = inflater.inflate(R.layout.fragment_pais, null);

        expListView = (ExpandableListView) activity.findViewById(R.id.expLV);
        paises = new Test().montaListaPaises();
        listAdapter = new ExpandableListAdapter(this.getActivity(), paises);

        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                MainActivity main = (MainActivity) getActivity();
                main.setmClube(paises.get(groupPosition).getClubes().get(childPosition));

                // Create new fragment and transaction
                Fragment clubeFragment = new ClubeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.container, clubeFragment);
                transaction.addToBackStack(null);

                transaction.commit();

                return true;
            }
        });

        // Criando o AdView.
        adView = (AdView) activity.findViewById(R.id.adView);

        // Fazendo uma requisição para recuperar o anúncio.
        AdRequest adRequest = new AdRequest.Builder()
                // Add a test device to show Test Ads
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("abc") //Random Text
                .setGender(AdRequest.GENDER_MALE)
                .build();

        // Adicionando a requisição no AdView.
        adView.loadAd(adRequest);

        return activity;
    }

    @Override
    public void onPause() {
        //Pausando o AdView ao pausar a activity
        adView.pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        //Reiniciando o AdView ao reiniciar a activity
        super.onResume();
        adView.resume();
    }

    @Override
    public void onDestroy() {
        //Destruindo o AdView ao destruir a activity
        adView.destroy();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
