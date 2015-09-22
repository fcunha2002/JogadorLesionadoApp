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
    ILLNESS (6, "illness"),
    THIGH_MUSCLE_STRAIN (7, "thigh_muscle_strain"),
    ANKLE_LIGAMENTS (8, "ankle_ligaments"),
    FIBULA_FRACTURE (9, "fibula_fracture"),
    ACHILLES_TENDONITIS (10, "achilles_tendonitis"),
    CALF_SHIN_INJURY (11, "calf_shin_injury"),
    BROKEN_NOSE (12, "broken_nose"),
    ACL_KNEE_LIGAMENT (13, "acl_knee_ligament"),
    BACK_INJURY (14, "back_injury"),
    KNOCK (15, "knock");

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
