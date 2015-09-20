package com.fabio.jogadorlesionado.bancodados;

import android.content.Context;

import com.fabio.jogadorlesionado.negocio.Clube;
import com.fabio.jogadorlesionado.negocio.Jogador;
import com.fabio.jogadorlesionado.negocio.Lesao;
import com.fabio.jogadorlesionado.negocio.Pais;
import com.fabio.jogadorlesionado.negocio.Posicao;
import com.fabio.jogadorlesionado.negocio.TipoLesao;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fábio Cunha on 09/09/2015.
 */
public class WebService {

    String data = "2015-01-01 00:00:00";

    public boolean atualizarValores(Context context){
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
        HttpConnectionParams.setSoTimeout(httpParams, 10000);

        HttpClient httpClient = new DefaultHttpClient();
        String server = "http://injuredplayer.esy.es/jlweb/";

        try {
            atualizaPaises(httpClient, server, context);
            atualizaClubes(httpClient, server, context);
            atualizaJogadores(httpClient, server, context);
            atualizaLesoes(httpClient, server, context);
        } catch (Exception e) {
            //Erro ao buscar dados
            return false;
        }

        return true;
    }

    private void atualizaPaises(HttpClient httpClient, String server, Context context) throws IOException, JSONException {
        ArrayList<Pais> paises = new ArrayList<Pais>();

        String url = server + "getPais.php";
        HttpPost httppost = new HttpPost(url);

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("dt_atualizacao", data));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpClient.execute(httppost, responseHandler);

        JSONObject json = new JSONObject(responseBody);
        JSONArray jArray = json.getJSONArray("paises");

        for (int i = 0; i < jArray.length(); i++) {

            JSONObject e = jArray.getJSONObject(i);
            String s = e.getString("dados");
            JSONObject jObject = new JSONObject(s);

            paises.add(montaPais(jObject));
        }

        PaisDAO paisDAO = new PaisDAO(context);
        paisDAO.openWrite();

        for (Pais pais : paises) {
            if (paisDAO.exists(pais.getId())){
                paisDAO.update(pais);
            }else{
                paisDAO.insert(pais);
            }
        }

        paisDAO.close();
    }

    private Pais montaPais(JSONObject jObject){
        Pais pais = new Pais();

        try {
            pais.setId(jObject.getLong("id"));
            pais.setNome(jObject.getString("nome"));
            pais.setBandeira(jObject.getString("bandeira"));
            pais.setControle(jObject.getInt("controle") == 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pais;
    }

    private void atualizaClubes(HttpClient httpClient, String server, Context context) throws IOException, JSONException {
        ArrayList<Clube> clubes = new ArrayList<Clube>();

        String url = server + "getClube.php";
        HttpPost httppost = new HttpPost(url);

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("dt_atualizacao", data));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpClient.execute(httppost, responseHandler);

        JSONObject json = new JSONObject(responseBody);
        JSONArray jArray = json.getJSONArray("clubes");

        for (int i = 0; i < jArray.length(); i++) {

            JSONObject e = jArray.getJSONObject(i);
            String s = e.getString("dados");
            JSONObject jObject = new JSONObject(s);

            clubes.add(montaClube(jObject));
        }

        ClubeDAO clubeDAO = new ClubeDAO(context);
        clubeDAO.openWrite();

        for (Clube clube : clubes) {
            if (clubeDAO.exists(clube.getId())){
                clubeDAO.update(clube);
            }else{
                clubeDAO.insert(clube);
            }
        }

        clubeDAO.close();
    }

    private Clube montaClube(JSONObject jObject){
        Clube clube = new Clube();
        Pais pais = new Pais();

        try {
            clube.setId(jObject.getLong("id"));
            clube.setNomeCompleto(jObject.getString("nome_completo"));
            clube.setNomeReduzido(jObject.getString("nome_reduzido"));
            clube.setEscudo(jObject.getString("escudo"));
            clube.setDivisao(jObject.getInt("divisao"));
            pais.setId(jObject.getInt("id_pais"));
            clube.setPais(pais);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return clube;
    }

    private void atualizaJogadores(HttpClient httpClient, String server, Context context) throws IOException, JSONException {
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

        String url = server + "getJogador.php";
        HttpPost httppost = new HttpPost(url);

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("dt_atualizacao", data));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpClient.execute(httppost, responseHandler);

        JSONObject json = new JSONObject(responseBody);
        JSONArray jArray = json.getJSONArray("jogadores");

        for (int i = 0; i < jArray.length(); i++) {

            JSONObject e = jArray.getJSONObject(i);
            String s = e.getString("dados");
            JSONObject jObject = new JSONObject(s);

            jogadores.add(montaJogador(jObject));
        }

        JogadorDAO jogadorDAO = new JogadorDAO(context);
        jogadorDAO.openWrite();

        for (Jogador jogador : jogadores) {
            if (jogadorDAO.exists(jogador.getId())){
                jogadorDAO.update(jogador);
            }else{
                jogadorDAO.insert(jogador);
            }
        }

        jogadorDAO.close();
    }

    private Jogador montaJogador(JSONObject jObject){
        Jogador jogador = new Jogador();
        Clube clube = new Clube();
        Pais pais = new Pais();

        try {
            jogador.setId(jObject.getLong("id"));
            jogador.setNomeCompleto(jObject.getString("nome_completo"));
            jogador.setNomeGuerra(jObject.getString("nome_guerra"));
            jogador.setFoto(jObject.getString("foto"));
            jogador.setPosicao(Posicao.valueOf(jObject.getString("posicao")));

            String data= jObject.getString("data_nascimento");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date d = formatter.parse(data);
                jogador.setDataNascimento(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            clube.setId(jObject.getInt("id_clube"));
            jogador.setClube(clube);
            pais.setId(jObject.getInt("id_pais"));
            jogador.setPais(pais);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jogador;
    }

    private void atualizaLesoes(HttpClient httpClient, String server, Context context) throws IOException, JSONException {
        ArrayList<Lesao> lesoes = new ArrayList<Lesao>();

        String url = server + "getLesao.php";
        HttpPost httppost = new HttpPost(url);

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("dt_atualizacao", data));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpClient.execute(httppost, responseHandler);

        JSONObject json = new JSONObject(responseBody);
        JSONArray jArray = json.getJSONArray("lesoes");

        for (int i = 0; i < jArray.length(); i++) {

            JSONObject e = jArray.getJSONObject(i);
            String s = e.getString("dados");
            JSONObject jObject = new JSONObject(s);

            lesoes.add(montaLesao(jObject));
        }

        LesaoDAO lesaoDAO = new LesaoDAO(context);
        lesaoDAO.openWrite();

        for (Lesao lesao : lesoes) {
            if (lesaoDAO.exists(lesao.getId())){
                lesaoDAO.update(lesao);
            }else{
                lesaoDAO.insert(lesao);
            }
        }

        lesaoDAO.close();
    }

    private Lesao montaLesao(JSONObject jObject){
        Lesao lesao = new Lesao();
        Jogador jogador = new Jogador();

        try {
            lesao.setId(jObject.getLong("id"));
            lesao.setDescricao(jObject.getString("descricao"));
            lesao.setTipo(TipoLesao.valueOf(jObject.getString("tipo")));

            try {
                String data= jObject.getString("data_inicio");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date d = formatter.parse(data);
                lesao.setDataInicio(d);
                data= jObject.getString("data_fim");
                d = formatter.parse(data);
                lesao.setDataFim(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            jogador.setId(jObject.getInt("id_jogador"));
            lesao.setJogador(jogador);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lesao;
    }

}
