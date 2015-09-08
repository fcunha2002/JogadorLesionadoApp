package com.fabio.jogadorlesionado.negocio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Fabio on 21/05/2015.
 */
public class Jogador implements Serializable {
    private long id;
    private String nomeCompleto;
    private String nomeGuerra;
    private Date dataNascimento;
    private Lesao lesaoAtual;
    private Contrato contrato;
    private String foto;
    private Posicao posicao;
    private Pais pais;
    private ArrayList<Lesao> historicoLesoes = new ArrayList<Lesao>();

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

    public Lesao getLesaoAtual() {
        return lesaoAtual;
    }

    public void setLesaoAtual(Lesao lesaoAtual) {
        this.lesaoAtual = lesaoAtual;
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

    public ArrayList<Lesao> getHistoricoLesoes() {
        return historicoLesoes;
    }

    public void setHistoricoLesoes(ArrayList<Lesao> historicoLesoes) {
        this.historicoLesoes = historicoLesoes;
    }

    @Override
    public String toString(){
        return this.nomeGuerra;
    }

}
