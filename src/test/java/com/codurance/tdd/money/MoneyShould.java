package com.codurance.tdd.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Solange
 */
@DisplayName("Money should")
class MoneyShould {

    @Test
    @DisplayName("multiply an amount by a number and receive an amount")
    void multiply_an_amount_by_a_number_and_receive_an_amount() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
    }

    @Test
    @DisplayName("not have any side effects")
    void not_have_any_side_effects() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(15), five.times(3));
        assertEquals(Money.dollar(5), five);
    }

    @Test
    @DisplayName("make sure same amounts are equal")
    void make_sure_same_amounts_are_equal() {
        Money five = Money.dollar(5);
        Money anotherFive = Money.dollar(5);
        assertThat(five.equals(anotherFive), is(true));
    }

    @Test
    @DisplayName("make sure different amounts are not equal")
    void make_sure_different_amounts_are_not_equal() {
        Money five = Money.dollar(5);
        Money six = Money.dollar(6);
        assertThat(five.equals(six), is(false));
    }

    @Test
    @DisplayName("multiply an amount in francs and receive an amount in francs")
    void multiply_an_amount_in_francs_and_receive_an_amount_in_francs() {
        Money cinq = Money.franc(5);
        assertEquals(Money.franc(10), cinq.times(2));
        assertEquals(Money.franc(15), cinq.times(3));
    }

    @Test
    @DisplayName("make sure same amounts in different currencies are not equal")
    void make_sure_same_amounts_in_different_currencies_are_not_equal() {
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    @DisplayName("return correct currency for given money")
    void return_correct_currency_for_money() {
        assertEquals("USD", Money.dollar(4).currency());
        assertEquals("CHF", Money.franc(4).currency());
    }

    /*
     The following test is not necessary anymore as we're replacing
     references to subclasses with the superclass without changing
     the meaning of the code, and testing equality is fully covered in earlier
     tests.

    @Test
    @DisplayName("be true when comparing francs and money of same amount")
    void be_true_when_comparing_francs_and_money_of_same_amount() {
        assertEquals(new Money(10, "CHF"), new Franc(10, "CHF"));
    }
    */

    @Test
    @DisplayName("add two amounts of money and receive resulting amount of money")
    void add_two_amounts_of_money_and_receive_an_amount_of_money() {
        Expression sum = Money.dollar(5).plus(Money.dollar(5));
        int amount = ((Sum) sum).augend.amount + ((Sum) sum).addend.amount;
        assertEquals(Money.dollar(10).amount, amount);
    }

    @Test
    @DisplayName("return correct reduced amount in currency of choice")
    void return_correct_reduced_amount_in_currency_of_choice() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    @DisplayName("make sure plus() returns a sum")
    void make_sure_plus_returns_a_sum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    @DisplayName("return correct reduced sum in currency of choice")
    void return_correct_reduced_sum_in_currency_of_choice() {
        Expression sum = new Sum(Money.dollar(4), Money.dollar(3));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    @DisplayName("return correct reduced money in currency of choice")
    void return_correct_reduced_money_in_currency_of_choice() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    @DisplayName("reduce money into different currency")
    void reduce_money_into_different_currency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    @DisplayName("return identity rate for same currency")
    void return_identity_rate_for_same_currency() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }


}
