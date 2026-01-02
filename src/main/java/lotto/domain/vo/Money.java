package lotto.domain.vo;

import java.util.Map;
import lotto.constant.ErrorMessage;
import lotto.constant.Rank;

public class Money {

    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        validateMoney(money);
        return new Money(money);
    }

    private static void validateMoney(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getErrorMessage());
        }
    }

    public int getLottoCount() {
        return money / 1000;
    }

    public double calculateProfit(Map<Rank, Integer> result) {
        long sumPrize = 0;
        for (Rank rank : result.keySet()) {
            sumPrize += rank.getPrice() * result.get(rank);
        }
        return (double) sumPrize / money * 100;
    }
}
