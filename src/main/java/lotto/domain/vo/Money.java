package lotto.domain.vo;

import java.util.Map;
import lotto.constant.ErrorMessage;
import lotto.constant.Rank;

public record Money(int money) {

    private static final int MONEY_UNIT = 1000;

    public static Money from(int money) {
        validateMoney(money);
        return new Money(money);
    }

    private static void validateMoney(int money) {
        if (money <= 0 || money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getErrorMessage());
        }
    }

    public int getLottoCount() {
        return money / MONEY_UNIT;
    }

    public double calculateProfit(Map<Rank, Integer> result) {
        long sumPrize = 0;
        for (Rank rank : result.keySet()) {
            sumPrize += rank.getPrice() * result.get(rank);
        }
        return (double) sumPrize / money * 100;
    }
}
