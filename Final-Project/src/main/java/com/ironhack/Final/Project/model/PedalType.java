package com.ironhack.Final.Project.model;




public enum PedalType {
    DYNAMICS,
    MODULATION,
    ECO;

    public static PedalType fromString(String value) {
        return PedalType.valueOf(value.toUpperCase());
    }
}
