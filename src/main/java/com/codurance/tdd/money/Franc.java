package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Franc extends Money {

    Franc(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier) {
        // take a step further in refactoring both "times" methods in
        // subclasses to be as similar as possible, so that we can
        // then move it up into the Money superclass
        return new Franc(amount * multiplier, currency);
    }

}
