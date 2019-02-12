package com.codecool.api;

import java.util.Map;
import java.util.Set;

public class Fact {

    private String id;
    private String description;
    private Map<String, Boolean> eval;
    private Set<String> idSet = eval.keySet();

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Set<String> getIdSet() {
        return idSet;
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
}
