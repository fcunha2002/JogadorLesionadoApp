package com.fabio.jogadorlesionado.negocio;

/**
 * Created by Fabio on 31/08/2015.
 */
public enum Posicao {
    GOLEIRO (1, "goalkeeper"),
    DEFENSOR (2, "defender"),
    MEIO_CAMPO(3, "midfielder"),
    ATACANTE (4, "attacker");

    private long id;
    private String stringVal;

    Posicao (long id, String stringVal){
        this.id = id;
        this.stringVal = stringVal;
    }

    public long getId() {
        return id;
    }

    public String getStringVal() {
        return stringVal;
    }
}
