package com.codurance.tdd.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
        assertThat(product.amount, is(10));
    }

    @Test
    @DisplayName("not have any side effects")
    void not_have_any_side_effects() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(3);
        assertThat(product.amount, is(15));
        assertThat(five.amount, is(5));
    }
}