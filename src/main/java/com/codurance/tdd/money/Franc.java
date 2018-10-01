package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Franc {

    private int amount;

    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    public boolean equals(Object obj) {
        Franc autre = (Franc) obj;
        return amount == autre.amount;
    }
}
