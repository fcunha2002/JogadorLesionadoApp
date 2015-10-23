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
    CONCUSSION (11, "concussion"),
    FIBULA_FRACTURE (12, "fibula_fracture"),
    GROIN_STRAIN (13, "groin_strain"),
    GROIN_PELVIS_INJURY (14, "groin_pelvis_injury"),
    HAMSTRING (15, "hamstring"),
    HEAD_INJURY (16, "head_injury"),
    HIP_THIGH_INJURY (17, "hip_thigh_injury"),
    ILLNESS (18, "illness"),
    KNEE_INJURY (19, "knee_injury"),
    KNOCK (20, "knock"),
    MCL_KNEE_LIGAMENT (21, "mcl_knee_ligament"),
    METATARSAL_FRACTURE (22, "metatarsal_fracture"),
    NECK_INJURY (23, "neck_injury"),
    PUBALGIA (24, "pubalgia"),
    RIB_INJURY (25, "rib_injury"),
    SHOULDER_INJURY (26, "shoulder_injury"),
    SPRAINED_ANKLE (27, "sprained_ankle"),
    THIGH_MUSCLE_STRAIN (28, "thigh_muscle_strain"),
    VIRAL_MENINGITIS (29, "viral_meningitis"),
    VIRUS (30, "virus");

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
