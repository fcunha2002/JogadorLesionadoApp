package com.fabio.jogadorlesionado.negocio;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fabio on 21/05/2015.
 */
public class Contrato implements Serializable {
    private long id;
    private Jogador jogador;
    private Clube clube;
    private Date dataInicio;
    private Date dataFinal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}
