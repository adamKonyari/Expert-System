package com.codecool.main;

import com.codecool.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ESProvider {

    private FactParser factParser;
    private RuleParser ruleParser;
    private Answer answer = new Answer();
    private Map<String, Boolean> answers;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public void collectAnswers() {
        answers = new HashMap<>();
        Ui ui = new Ui();

        while(ruleParser.getRuleRepository().getIterator().hasNext()){
            String input;
            int i = 0;
            for(Question question: ruleParser.getRuleRepository().getQuestions()) {
                Question current = ruleParser.getRuleRepository().getIterator().next();
                System.out.println(current.getQuestion() + " [Y / N]");
                input = ui.getInput();
                while(!isValid(input)) {
                    System.out.println(ruleParser.getRuleRepository().getQuestions().get(i).getQuestion() + " [Y / N]");
                    input = ui.getInput();
                }
                i++;
                answers.put(question.getId(), answer.evaluateAnswerByInput(input));
            }
        }
    }

    public boolean isValid(String answer) {
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")) {
            return true;
        } else {
            return false;
        }
    }

    public List<Fact> evaluate() {
        List<Fact> result = new ArrayList<>();
        Map<Fact, Map<String, Boolean>> factEval = new HashMap<>();

        for(Fact fact: factParser.getFactRepository().getFacts()) {
            factEval.put(fact, fact.getEval());
        }

        for(Map.Entry<Fact, Map<String, Boolean>> fact: factEval.entrySet()) {
            if(fact.getValue().equals(answers)) {
                result.add(fact.getKey());
            }
        }

        return result;
    }
}
