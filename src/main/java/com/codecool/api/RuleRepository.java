package com.codecool.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleRepository {

    private Iterator<Question> questionIterator;
    private List<Question> questions;

    public RuleRepository() {
        this.questionIterator = new QuestionIterator();
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Iterator<Question> getIterator() {
        return questionIterator;
    }

    public class QuestionIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < questions.size();
        }

        @Override
        public Question next() {
            if (this.hasNext()) {
                return questions.get(index++);
            } else {
                return null;
            }
        }
    }
}

