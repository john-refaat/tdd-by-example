package guru.springframework;

/**
 * Created By john on Aug, 2019
 **/

public class Sum implements Expression {

    private final Expression augend;
    private final Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression added) {
        return new Sum(this, added);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier),  addend.times(multiplier));
    }


    public Expression getAugend() {
        return augend;
    }

    public Expression getAddend() {
        return addend;
    }
}
