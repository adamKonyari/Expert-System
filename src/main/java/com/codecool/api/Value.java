package com.codecool.api;

import java.util.List;

public abstract class Value {

    private List<String> inputPattern;
    private boolean selectionType;

    public List<String> getInputPattern() {
        return inputPattern;
    }

    public boolean getSelectionType() {
        return selectionType;
    }
}
