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
        five.times(2);
        assertThat(five.amount, is(10));
    }
}
