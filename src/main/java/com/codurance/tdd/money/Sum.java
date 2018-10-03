package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Sum implements Expression {

    // Let's start generalizing and working with Expressions
    Expression augend;
    Expression addend;

    Sum (Expression augend, Expression addend) {
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
        int amount = augend.reduce(bank, to).amount
                        + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
