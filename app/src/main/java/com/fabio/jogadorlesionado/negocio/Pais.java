package com.fabio.jogadorlesionado.negocio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Fabio on 21/05/2015.
 */
public class Pais implements Serializable {
    private long id; //Identificador chave
    private String nome; //valor que indica a chave no arquivo 'strings' que guarda o nome do país
    private String bandeira; //nome do arquivo que possui o figura da bandeira. padrão pX onde X é o id do país
    private boolean controle; //booleano que diz se o país é também acompanhado pelo app
    private ArrayList<Clube> clubes = new ArrayList<Clube>(); //lista de clubes do país

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

    public boolean isControle() {
        return controle;
    }

    public void setControle(boolean controle) {
        this.controle = controle;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
