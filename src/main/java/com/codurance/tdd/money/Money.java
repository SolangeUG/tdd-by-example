package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Money {

    int amount;
    String currency;

    /**
     * Move the constructor to the superclass,
     * now that constructors in both subclasses are identical
     * @param amount amount
     * @param currency currency
     */
    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Factory method to reduce direct references to Dollar subclass
     * @param amount amount
     * @return a Dollar instance with the specified amount
     */
    static Money dollar(int amount) {
        // replace reference to subclass without changing meaning of code
        return new Money(amount, "USD");
    }

    /**
     * Factory method to reduce direct references to Franc subclass
     * @param amount amount
     * @return a Franc instance with the specified amount
     */
    static Money franc(int amount) {
        // replace reference to subclass without changing meaning of code
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    /**
     * In order to further reduce references to subclasses,
     * turn the times abstract method into a concrete one.
     * @param multiplier multiplier
     * @return a Money instance with multiplied amount
     */
    Money times(int multiplier) {
        // Now that both times() methods in subclasses are identical,
        // let's push it up in here.
        return new Money(amount * multiplier, currency);
    }

    /**
     * Introduce notion of currency
     * @return currency
     */
    String currency() {
        return currency;
    }

    @Override
    public String toString() {
        // as toString() is used for debugging reasons,
        // it's OK to add it to our implementation without
        // adding a test first! This exception is allowed in
        // this case as the tests are already RED anyway.
        return amount + " " + currency;
    }
}
