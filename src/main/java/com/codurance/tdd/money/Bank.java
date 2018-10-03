package com.codurance.tdd.money;

import java.util.Hashtable;

/**
 * @author Solange
 */
class Bank {

    private Hashtable<Pair, Integer> rates = new Hashtable<>();

    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        return rates.get(new Pair(from, to));
    }

    private class Pair {
        String from;
        String to;

        Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            return from.equals(pair.from)
                    && to.equals(pair.to);
        }

        @Override
        public int hashCode() {
            // This is a terrible value, but it has the advantage of getting
            // us going quickly in our refactoring.
            // Currency lookup will look like linear search.
            return 0;
        }
    }
}
