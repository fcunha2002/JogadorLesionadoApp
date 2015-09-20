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

import com.fabio.jogadorlesionado.bancodados.JogadorDAO;
import com.fabio.jogadorlesionado.bancodados.LesaoDAO;
import com.fabio.jogadorlesionado.negocio.Clube;
import com.fabio.jogadorlesionado.negocio.Jogador;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class JogadorFragment extends Fragment {
    ImageView ivFoto;
    ImageView ivBandPais;
    TextView tvNome;
    TextView tvNomeCompl;
    TextView tvPosicao;
    ListView lvLesoes;
    ArrayAdapter<Jogador> jogadorAdapter;

    private AdView adView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View activity = inflater.inflate(R.layout.fragment_jogador, null);

        MainActivity main = (MainActivity) getActivity();

        Jogador jogador = main.getmJogador();

        if (jogador.getHistoricoLesoes().size() == 0) {
            LesaoDAO lesaoDAO = new LesaoDAO(main);
            lesaoDAO.openRead();
            jogador.getHistoricoLesoes().addAll(lesaoDAO.getAll(jogador));
            lesaoDAO.close();
        }

        ivFoto = (ImageView) activity.findViewById(R.id.iv_foto);
        ivFoto.setImageResource(this.getResources().getIdentifier(
                "com.fabio.jogadorlesionado:drawable/" + jogador.getFoto(), null, null));

        ivBandPais = (ImageView) activity.findViewById(R.id.iv_pais);
        ivBandPais.setImageResource(this.getResources().getIdentifier(
                "com.fabio.jogadorlesionado:drawable/" + jogador.getPais().getBandeira(), null, null));

        tvNome = (TextView) activity.findViewById(R.id.tv_nome);
        tvNome.setText(jogador.getNomeGuerra());

        tvNomeCompl = (TextView) activity.findViewById(R.id.tv_nome_compl);
        tvNomeCompl.setText(jogador.getNomeCompleto());

        tvPosicao = (TextView) activity.findViewById(R.id.tvPosicao);
        tvPosicao.setText(main.getResources().getString(
                main.getResources().getIdentifier(
                        "com.fabio.jogadorlesionado:string/" + jogador.getPosicao().getStringVal(), null, null)));

        lvLesoes = (ListView) activity.findViewById(R.id.lvLesoes);
        lvLesoes.setAdapter(new ListViewHistLesaoAdapter(this.getContext(), jogador.getHistoricoLesoes()));

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
