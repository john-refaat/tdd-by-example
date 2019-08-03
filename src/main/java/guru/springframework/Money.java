package guru.springframework;

import java.util.Objects;

/**
 * Created By john on Aug, 2019
 **/

public class Money implements Expression {
    final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String currency() {
        return currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }


    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public Expression plus (Expression added) {
        return new Sum(this, added);
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }


    @Override
    public Money reduce(Bank bank, String to) {
        int rate =  bank.rate(this.currency, to);
        return new Money(amount/rate, to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount
                && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

}
