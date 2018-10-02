package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Dollar extends Money {

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier) {
        // take a step further in refactoring both "times" methods in
        // subclasses to be as similar as possible, so that we can
        // then move it up into the Money superclass.

        // However, as this breaks our tests, let's backtrack a bit,
        // make the tests green again, before (re)introducing this change.
        return new Dollar(amount * multiplier, currency);
    }

}
