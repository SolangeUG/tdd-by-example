package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Money {

    int amount;

    /**
     * Factory method to reduce direct references to subclasses
     * @param amount amount
     * @return a Dollar instance with the specified amount
     */
    static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && getClass().equals(money.getClass());
    }
}
