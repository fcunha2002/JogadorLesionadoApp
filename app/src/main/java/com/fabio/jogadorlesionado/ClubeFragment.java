package com.fabio.jogadorlesionado;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fabio.jogadorlesionado.negocio.Clube;
import com.fabio.jogadorlesionado.negocio.Jogador;
import com.fabio.jogadorlesionado.negocio.ListViewJogadorAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ClubeFragment extends Fragment {
    ImageView ivEscudo;
    ImageView ivBandPais;
    TextView tvNomeClube;
    TextView tvNomeCompl;
    ListView lvLesionados;
    ArrayAdapter<Jogador> jogadorAdapter;

    private AdView adView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View activity = inflater.inflate(R.layout.fragment_clube, null);

        MainActivity main = (MainActivity) getActivity();

        Clube clube = main.getmClube();
        ivEscudo = (ImageView) activity.findViewById(R.id.iv_escudo);
        ivEscudo.setImageResource(this.getResources().getIdentifier(
                "com.fabio.jogadorlesionado:drawable/" + clube.getEscudo(), null, null));

        ivBandPais = (ImageView) activity.findViewById(R.id.iv_pais);
        ivBandPais.setImageResource(this.getResources().getIdentifier(
                "com.fabio.jogadorlesionado:drawable/" + clube.getPais().getBandeira(), null, null));

        tvNomeClube = (TextView) activity.findViewById(R.id.tv_nome_clube);
        tvNomeClube.setText(clube.getNomeReduzido());

        tvNomeCompl = (TextView) activity.findViewById(R.id.tv_nome_compl);
        tvNomeCompl.setText(clube.getNomeCompleto());

        lvLesionados = (ListView) activity.findViewById(R.id.lv_lesionados);
        lvLesionados.setAdapter(new ListViewJogadorAdapter(this.getContext(), clube.getLesionados()));

/*        Toast t = Toast.makeText(this,
                clube.getNomeCompleto() + "\n" +
                clube.getNomesLesionados(),
                Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER,0,0);
        t.show();*/

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
