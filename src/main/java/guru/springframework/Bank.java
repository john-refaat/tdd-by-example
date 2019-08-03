package guru.springframework;

import java.util.HashMap;

/**
 * Created By john on Aug, 2019
 **/

public class Bank {

    private final HashMap<Pair, Integer> rateMap = new HashMap<>();

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public int rate(String from, String to) {
        return from.equals(to)? 1 : rateMap.get(new Pair(from , to));
    }

    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
    }
}
