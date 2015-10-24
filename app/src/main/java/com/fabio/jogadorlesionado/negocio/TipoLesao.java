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
    BROKEN_HAND (6, "broken_hand"),
    BROKEN_LEG (7, "broken_leg"),
    BROKEN_NOSE (8, "broken_nose"),
    BROKEN_TOE (9, "broken_toe"),
    CALF_MUSCLE_STRAIN (10, "calf_muscle_strain"),
    CALF_SHIN_INJURY (11, "calf_shin_injury"),
    CONCUSSION (12, "concussion"),
    FIBULA_FRACTURE (13, "fibula_fracture"),
    GROIN_STRAIN (14, "groin_strain"),
    GROIN_PELVIS_INJURY (15, "groin_pelvis_injury"),
    HAMSTRING (16, "hamstring"),
    HEAD_INJURY (17, "head_injury"),
    HIP_THIGH_INJURY (18, "hip_thigh_injury"),
    ILLNESS (19, "illness"),
    KNEE_INJURY (20, "knee_injury"),
    KNOCK (21, "knock"),
    MCL_KNEE_LIGAMENT (22, "mcl_knee_ligament"),
    METATARSAL_FRACTURE (23, "metatarsal_fracture"),
    NECK_INJURY (24, "neck_injury"),
    PUBALGIA (25, "pubalgia"),
    RIB_INJURY (26, "rib_injury"),
    SHOULDER_INJURY (27, "shoulder_injury"),
    SPRAINED_ANKLE (28, "sprained_ankle"),
    THIGH_MUSCLE_STRAIN (29, "thigh_muscle_strain"),
    VIRAL_MENINGITIS (30, "viral_meningitis"),
    VIRUS (31, "virus");

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
