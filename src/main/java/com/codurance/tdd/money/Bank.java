package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Bank {

    Money reduce(Expression source, String to) {
        Sum sum = (Sum) source;
        int amount = ((Sum) source).augend.amount
                        + ((Sum) source).addend.amount;
        return new Money(amount, to);
    }
}
