package com.codurance.tdd.money;

/**
 * @author Solange
 */
interface Expression {

    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);
}
