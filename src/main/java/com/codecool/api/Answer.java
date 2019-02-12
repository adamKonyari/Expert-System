package com.codecool.api;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private List<Value> valueList = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) {
        if(input.equalsIgnoreCase("yes")) {
            return true;
        } else if(input.equalsIgnoreCase("no")) {
            return false;
        }
        return false;
    }

    public void addValue(Value value) {
        valueList.add(value);
    }
}
