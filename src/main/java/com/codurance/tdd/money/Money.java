package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Money {

    int amount;

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount;
    }
}
