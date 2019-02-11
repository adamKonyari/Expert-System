package com.codecool.api;

public class SingeValue extends Value {

    String param;
    boolean selectionType;

    public SingeValue(String param, boolean selectionType) {
        this.param = param;
        this.selectionType = selectionType;
    }
}
