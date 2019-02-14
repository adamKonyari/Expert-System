package com.codecool.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {

    private String id;
    private String description;
    private Map<String, Boolean> eval = new HashMap<>();

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public void setFactValueById(String id, Boolean value) {
        this.eval.put(id, value);
    }

    public Boolean getValueById(String id) {
        return eval.get(id);
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Boolean> getEval() {
        return eval;
    }
}
