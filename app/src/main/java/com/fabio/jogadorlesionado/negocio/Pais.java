package com.fabio.jogadorlesionado.negocio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Fabio on 21/05/2015.
 */
public class Pais implements Serializable {
    private long id;
    private String nome;
    private String bandeira;
    private ArrayList<Clube> clubes = new ArrayList<Clube>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public ArrayList<Clube> getClubes() {
        return clubes;
    }

    public void setClubes(ArrayList<Clube> clubes) {
        this.clubes = clubes;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
