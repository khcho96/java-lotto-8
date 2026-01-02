package lotto.domain.vo;

import lotto.constant.ErrorMessage;

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
        return money % 1000;
    }

    public int getMoney() {
        return money;
    }
}
