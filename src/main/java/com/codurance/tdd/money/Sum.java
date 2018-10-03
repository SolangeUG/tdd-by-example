package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Sum implements Expression {

    Money augend;
    Money addend;

    Sum (Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    /**
     * Add a reduce method for Sum objects,
     * to avoid class casting in the Bank class.
     * @param to currency
     * @return the reduced money in the currency of choice
     */
    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}
