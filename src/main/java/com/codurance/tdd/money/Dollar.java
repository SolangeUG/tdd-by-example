package com.codurance.tdd.money;

/**
 * @author Solange
 */
class Dollar {

    private int amount;

    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public boolean equals(Object object) {
        Dollar other = (Dollar) object;
        return amount == other.amount;
    }
}
