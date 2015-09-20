package com.fabio.jogadorlesionado.negocio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Fabio on 05/09/2015.
 */
public class Lesao implements Serializable {
    private long id;
    private Jogador jogador;
    private Date dataInicio;
    private Date dataFim;
    private TipoLesao tipo;
    private String descricao;

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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public long getTempoLesao(){
        Date data_atual = new Date();

        Calendar  cal = Calendar.getInstance();
        cal.setTime(data_atual);
        data_atual = cal.getTime();

        if (dataFim != null){
            return (dataFim.getTime() - dataInicio.getTime()) / (24 * 60 * 60 * 1000);
        }else{
            return (data_atual.getTime() - dataInicio.getTime()) / (24 * 60 * 60 * 1000);
        }
    }

    public String getDataInicioFormatada(){
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        return dt.format(this.getDataInicio());
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataFimFormatada(){
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        return dt.format(this.getDataFim());
    }

    public TipoLesao getTipo() {
        return tipo;
    }

    public void setTipo(TipoLesao tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
