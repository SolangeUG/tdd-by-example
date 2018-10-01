package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Dollar {
    int amount;

    Dollar(int amount) {
        this.amount = amount;
    }

    void times(int multiplier) {
        amount *= multiplier;
    }
}
