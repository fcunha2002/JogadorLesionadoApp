package com.fabio.jogadorlesionado.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabio on 21/05/2015.
 */
public class Clube implements Serializable {
    private long id;
    private String escudo;
    private String nomeCompleto;
    private String nomeReduzido;
    private Pais pais;
    private List<Jogador> lesionados = new ArrayList<Jogador>();

    public List<Jogador> getLesionados() {
        return lesionados;
    }

    public void setLesionados(List<Jogador> lesionados) {
        this.lesionados = lesionados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeReduzido() {
        return nomeReduzido;
    }

    public void setNomeReduzido(String nomeReduzido) {
        this.nomeReduzido = nomeReduzido;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    @Override
    public String toString(){
        return this.getNomeReduzido();
    }

    public String getNomesLesionados() {
        String nomes = "";
        for (Jogador j : this.lesionados) {
            nomes = nomes + j.getNomeGuerra() + "\n";
        }
        if(nomes.length()>0) {
            return nomes.substring(0, nomes.length() - 1);
        } else {
            return nomes;
        }
    }

}
