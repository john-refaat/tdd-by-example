package guru.springframework;

/**
 * Created By john on Aug, 2019
 **/

public interface Expression {

    Money reduce(Bank bank, String to);
    Expression plus (Expression added);
    Expression times(int multiplier);
}
