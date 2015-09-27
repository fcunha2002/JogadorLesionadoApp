package com.fabio.jogadorlesionado.negocio;

/**
 * Created by Fabio on 31/08/2015.
 */
public enum TipoLesao {
    ACHILLES_TENDONITIS (1, "achilles_tendonitis"),
    ACL_KNEE_LIGAMENT (2, "acl_knee_ligament"),
    ANKLE_FOOT_INJURY (3, "ankle_foot_injury"),
    ANKLE_LIGAMENTS (4, "ankle_ligaments"),
    BACK_INJURY (5, "back_injury"),
    BROKEN_NOSE (6, "broken_nose"),
    BROKEN_TOE (7, "broken_toe"),
    CALF_MUSCLE_STRAIN (8, "calf_muscle_strain"),
    CALF_SHIN_INJURY (9, "calf_shin_injury"),
    FIBULA_FRACTURE (10, "fibula_fracture"),
    GROIN_STRAIN (11, "groin_strain"),
    HAMSTRING (12, "hamstring"),
    HIP_THIGH_INJURY (13, "hip_thigh_injury"),
    ILLNESS (14, "illness"),
    KNEE_INJURY (15, "knee_injury"),
    KNOCK (16, "knock"),
    MCL_KNEE_LIGAMENT (17, "mcl_knee_ligament"),
    THIGH_MUSCLE_STRAIN (18, "thigh_muscle_strain"),
    VIRUS (19, "virus");

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
