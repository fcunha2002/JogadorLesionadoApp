package com.fabio.jogadorlesionado.negocio;

/**
 * Created by Fabio on 31/08/2015.
 */
public enum TipoLesao {
    KNEE_INJURY (1, "knee_injury"),
    GROIN_STRAIN (2, "groin_strain"),
    HAMSTRING (3, "hamstring"),
    CALF_MUSCLE_STRAIN (4, "calf_muscle_strain"),
    ANKLE_FOOT_INJURY (5, "ankle_foot_injury"),
    ILLNESS (6, "illness");

    private long id;
    private String stringVal;

    TipoLesao(long id, String stringVal){
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
