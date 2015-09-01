package com.fabio.jogadorlesionado.negocio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Fabio on 21/05/2015.
 */
public class Jogador implements Serializable {
    private long id;
    private String nomeCompleto;
    private String nomeGuerra;
    private Date dataNascimento;
    private Date dataLesaoAtual;
    private Contrato contrato;
    private String foto;
    private Posicao posicao;
    private Pais pais;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Date getDataLesaoAtual() {
        return dataLesaoAtual;
    }

    public String getDataLesaoAtualFormatada(){
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        return dt.format(this.getDataLesaoAtual());
    }

    public void setDataLesaoAtual(Date dataLesaoAtual) {
        this.dataLesaoAtual = dataLesaoAtual;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString(){
        return this.nomeGuerra;
    }

}
