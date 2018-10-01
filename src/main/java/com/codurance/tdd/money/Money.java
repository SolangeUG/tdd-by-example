package com.codurance.tdd.money;

/**
 * @author Solange
 */
abstract class Money {

    int amount;
    String currency;

    /**
     * Factory method to reduce direct references to Dollar subclass
     * @param amount amount
     * @return a Dollar instance with the specified amount
     */
    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    /**
     * Factory method to reduce direct references to Franc subclass
     * @param amount amount
     * @return a Franc instance with the specified amount
     */
    static Money franc(int amount) {
        return new Franc(amount, "CHF");
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

    /**
     * Introduce notion of currency
     * @return currency
     */
    String currency() {
        return currency;
    }
}
