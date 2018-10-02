package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Sum implements Expression {

    Money augend;
    Money addend;

    Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }
}