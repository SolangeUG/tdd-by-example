package com.codurance.tdd.money;

/**
 * @author Solange
 */
abstract class Money {

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

    /**
     * In order to further reduce references to subclasses,
     * introduce this abstract method and have it be called.
     * @param multiplier multiplier
     * @return a Money instance with multiplied amount
     */
    abstract Money times(int multiplier);
}
