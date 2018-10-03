package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Bank {

    Money reduce(Expression source, String to) {
        return source.reduce(to);
    }
}
