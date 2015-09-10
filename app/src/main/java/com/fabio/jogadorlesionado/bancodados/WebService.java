package com.fabio.jogadorlesionado.bancodados;

import android.content.Context;

import com.fabio.jogadorlesionado.negocio.Pais;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fábio Cunha on 09/09/2015.
 */
public class WebService {

    public boolean atualizarValores(Context context){
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
        HttpConnectionParams.setSoTimeout(httpParams, 10000);

        HttpClient httpClient = new DefaultHttpClient();
//        String server = "http://192.168.0.14/jlweb/";
        String server = "http://10.32.84.17/jlweb/";

        try {
            atualizaPaises(httpClient, server, context);

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

//            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
//            nameValuePairs.add(new BasicNameValuePair("codigo", "meus_dados"));
//            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
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
            paisDAO.insert(pais);
        }

        paisDAO.close();

    }

    private Pais montaPais(JSONObject jObject){
        Pais pais = new Pais();

        try {
            pais.setId(jObject.getLong("id"));
            pais.setNome(jObject.getString("nome"));
            pais.setBandeira(jObject.getString("bandeira"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pais;
    }


}
