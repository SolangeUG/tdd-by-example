package com.codurance.tdd.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Solange
 */
@DisplayName("Dollar should")
class DollarShould {

    @Test
    @DisplayName("multiply an amount by a number and receive an amount")
    void multiply_an_amount_by_a_number_and_receive_an_amount() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(product, new Dollar(10));
    }

    @Test
    @DisplayName("not have any side effects")
    void not_have_any_side_effects() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(3);
        assertEquals(new Dollar(15), product);
        assertEquals(new Dollar(5), five);
    }

    @Test
    @DisplayName("make sure same amounts are equal")
    void make_sure_same_amounts_are_equal() {
        Dollar five = new Dollar(5);
        Dollar anotherFive = new Dollar(5);
        assertThat(five.equals(anotherFive), is(true));
    }

    @Test
    @DisplayName("make sure different amounts are not equal")
    void make_sure_different_amounts_are_not_equal() {
        Dollar five = new Dollar(5);
        Dollar six = new Dollar(6);
        assertThat(five.equals(six), is(false));
    }
}
