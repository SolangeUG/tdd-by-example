package com.codurance.tdd.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Solange
 */
@DisplayName("Dollar should")
class DollarShould {

    @Test
    @DisplayName("multiply an amount by a number and receive an amount")
    void multiply_an_amount_by_a_number_and_receive_an_amount() {
        Dollar five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
    }

    @Test
    @DisplayName("not have any side effects")
    void not_have_any_side_effects() {
        Dollar five = Money.dollar(5);
        assertEquals(Money.dollar(15), five.times(3));
        assertEquals(Money.dollar(5), five);
    }

    @Test
    @DisplayName("make sure same amounts are equal")
    void make_sure_same_amounts_are_equal() {
        Dollar five = Money.dollar(5);
        Dollar anotherFive = Money.dollar(5);
        assertThat(five.equals(anotherFive), is(true));
    }

    @Test
    @DisplayName("make sure different amounts are not equal")
    void make_sure_different_amounts_are_not_equal() {
        Dollar five = Money.dollar(5);
        Dollar six = Money.dollar(6);
        assertThat(five.equals(six), is(false));
    }

    @Test
    @DisplayName("multiply an amount in francs and receive an amount in francs")
    void multiply_an_amount_in_francs_and_receive_an_amount_in_francs() {
        Franc cinq = new Franc(5);
        assertEquals(new Franc(10), cinq.times(2));
        assertEquals(new Franc(15), cinq.times(3));
    }

    @Test
    @DisplayName("make sure same amounts in different currencies are not equal")
    void make_sure_same_amounts_in_different_currencies_are_not_equal() {
        assertNotEquals(Money.dollar(5), new Franc(5));
    }
}
