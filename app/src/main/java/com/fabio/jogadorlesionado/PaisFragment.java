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
        paises = montaListaPaises();
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

    private List<Pais> montaListaPaises(){
        ArrayList<Pais> paises = new ArrayList<Pais>();

        Pais pais = new Pais();
        pais.setId(1);
        pais.setNome("Argentina");
        pais.setBandeira("argentina");

        paises.add(pais);

        pais = new Pais();
        pais.setId(2);
        pais.setNome("Brasil");
        pais.setBandeira("brasil");

        paises.add(pais);

        pais = new Pais();
        pais.setId(3);
        pais.setNome("Chile");
        pais.setBandeira("chile");

        paises.add(pais);

        return montaListaClubes(paises);
    }

    private List<Pais> montaListaClubes(List<Pais> paises) {
        Clube clube;

        for (Pais pais : paises) {
            if (pais.getId() == 2) {
                clube = new Clube();
                clube.setId(1);
                clube.setNomeCompleto("Sport Club Internacional");
                clube.setNomeReduzido("Internacional");
                clube.setEscudo("internacional");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(2);
                clube.setNomeCompleto("Gremio Foot-Ball Porto Alegrense");
                clube.setNomeReduzido("Gremio");
                clube.setEscudo("gremio");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(3);
                clube.setNomeCompleto("Club de Regatas Vasco da Gama");
                clube.setNomeReduzido("Vasco");
                clube.setEscudo("vasco");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(4);
                clube.setNomeCompleto("Sport Club Corinthians Paulista");
                clube.setNomeReduzido("Corinthians");
                clube.setEscudo("corinthians");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(5);
                clube.setNomeCompleto("Fluminense Football Club");
                clube.setNomeReduzido("Fluminense");
                clube.setEscudo("fluminense");
                clube.setPais(pais);
                pais.getClubes().add(clube);
            } else if (pais.getId() == 1) {
                clube = new Clube();
                clube.setId(6);
                clube.setNomeCompleto("Club Atletico Boca Juniors");
                clube.setNomeReduzido("Boca Juniors");
                clube.setEscudo("boca");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(7);
                clube.setNomeCompleto("Club Atletico Belgrano");
                clube.setNomeReduzido("Belgrano");
                clube.setEscudo("belgrano");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(8);
                clube.setNomeCompleto("Club Atletico Rosario Central");
                clube.setNomeReduzido("Rosario Central");
                clube.setEscudo("rosario");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(9);
                clube.setNomeCompleto("Club Atletico San Lorenzo de Almagro");
                clube.setNomeReduzido("San Lorenzo");
                clube.setEscudo("sanlorenzo");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(10);
                clube.setNomeCompleto("Club Atletico River Plate");
                clube.setNomeReduzido("River Plate");
                clube.setEscudo("riverplate");
                clube.setPais(pais);
                pais.getClubes().add(clube);
            } else if (pais.getId() == 3) {
                clube = new Clube();
                clube.setId(11);
                clube.setNomeCompleto("Club Social y Deportivo Colo-Colo");
                clube.setNomeReduzido("Colo Colo");
                clube.setEscudo("colocolo");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(12);
                clube.setNomeCompleto("Club Deportivo Universidad Catolica");
                clube.setNomeReduzido("Universidad Catolica");
                clube.setEscudo("unicatolica");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(13);
                clube.setNomeCompleto("Club Universidad de Chile");
                clube.setNomeReduzido("Universidad de Chile");
                clube.setEscudo("unichile");
                clube.setPais(pais);
                pais.getClubes().add(clube);

                clube = new Clube();
                clube.setId(14);
                clube.setNomeCompleto("Club Deportivo Huachipato");
                clube.setNomeReduzido("Huachipato");
                clube.setEscudo("huachipato");
                clube.setPais(pais);
                pais.getClubes().add(clube);
            }
        }

        return montaListaJogadores(paises);
    }

    private List<Pais> montaListaJogadores(List<Pais> paises) {
        Jogador jogador;
        Contrato contrato;


        for (Pais pais : paises) {
            for (Clube clube : pais.getClubes()){
                if (clube.getId() == 1) { //Internacional
                    jogador = new Jogador();
                    jogador.setId(1);
                    jogador.setNomeCompleto("Andres Nicolas D'Alessandro");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("15/04/1981"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setNomeGuerra("D'Alessandro");
                    jogador.setFoto("dalessandro");
                    clube.getLesionados().add(jogador);

                    jogador = new Jogador();
                    jogador.setId(2);
                    jogador.setNomeCompleto("Eduardo Colcenti Antunes");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("24/02/1992"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setNomeGuerra("Eduardo Sasha");
                    jogador.setFoto("sasha");
                    clube.getLesionados().add(jogador);

                    jogador = new Jogador();
                    jogador.setId(3);
                    jogador.setNomeCompleto("Rever Humberto Alves Araujo");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("04/01/1985"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setNomeGuerra("Rever");
                    jogador.setFoto("rever");
                    clube.getLesionados().add(jogador);
                } else if (clube.getId() == 2) {//Gremio
                    jogador = new Jogador();
                    jogador.setId(4);
                    jogador.setNomeCompleto("Ramiro Moschen Benetti");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("22/05/1993"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setNomeGuerra("Ramiro");
                    jogador.setFoto("ramiro");
                    clube.getLesionados().add(jogador);
                } else if (clube.getId() == 3) {//Vasco
                    jogador = new Jogador();
                    jogador.setId(5);
                    jogador.setNomeCompleto("Claudinei Cardoso Felix da Silva");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("06/12/1985"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setNomeGuerra("Nei");
                    jogador.setFoto("nei");
                    clube.getLesionados().add(jogador);
                } else if (clube.getId() == 4) {//Corinthians
                    jogador = new Jogador();
                    jogador.setId(6);
                    jogador.setNomeCompleto("Luciano da Rocha Neves");
                    try {
                        jogador.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("18/05/1993"));
                    } catch (ParseException e) {
                        jogador.setDataNascimento(null);
                        e.printStackTrace();
                    }
                    jogador.setNomeGuerra("Luciano");
                    jogador.setFoto("luciano");
                    clube.getLesionados().add(jogador);
                }
            }
        }

        return paises;
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
