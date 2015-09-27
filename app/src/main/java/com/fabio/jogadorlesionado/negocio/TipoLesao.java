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
    BROKEN_LEG (6, "broken_leg"),
    BROKEN_NOSE (7, "broken_nose"),
    BROKEN_TOE (8, "broken_toe"),
    CALF_MUSCLE_STRAIN (9, "calf_muscle_strain"),
    CALF_SHIN_INJURY (10, "calf_shin_injury"),
    FIBULA_FRACTURE (11, "fibula_fracture"),
    GROIN_STRAIN (12, "groin_strain"),
    GROIN_PELVIS_INJURY (13, "groin_pelvis_injury"),
    HAMSTRING (14, "hamstring"),
    HEAD_INJURY (15, "head_injury"),
    HIP_THIGH_INJURY (16, "hip_thigh_injury"),
    ILLNESS (17, "illness"),
    KNEE_INJURY (18, "knee_injury"),
    KNOCK (19, "knock"),
    MCL_KNEE_LIGAMENT (20, "mcl_knee_ligament"),
    METATARSAL_FRACTURE (21, "metatarsal_fracture"),
    NECK_INJURY (22, "neck_injury"),
    PUBALGIA (23, "pubalgia"),
    RIB_INJURY (24, "rib_injury"),
    SPRAINED_ANKLE (25, "sprained_ankle"),
    THIGH_MUSCLE_STRAIN (26, "thigh_muscle_strain"),
    VIRUS (27, "virus");

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
