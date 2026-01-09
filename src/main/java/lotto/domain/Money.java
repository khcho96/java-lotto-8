package lotto.domain;

import lotto.constant.ErrorMessage;

public class Money {

    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        validate(money);
        return new Money(money);
    }

    public static void validate(int money) {
        if (money % 1000 != 0 || money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getErrorMessage());
        }
    }
}
