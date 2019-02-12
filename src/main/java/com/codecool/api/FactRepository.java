package com.codecool.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {

    private List<Fact> facts;
    private Iterator<Fact> iterator;

    public FactRepository() {
        this.facts = new ArrayList<>();
        this.iterator = new FactIterator();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return iterator;
    }

    public class FactIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            return index < facts.size();
        }

        @Override
        public Fact next() {
            if (this.hasNext()) {
                return facts.get(index++);
            }
            return null;
        }
    }
}
