package lotto.domain;

public class LottoMachine {

    private final Money money;

    private LottoMachine(Money money) {
        this.money = money;
    }

    public static LottoMachine from(int money) {
        return new LottoMachine(Money.from(money));
    }
}
