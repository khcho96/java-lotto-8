package lotto.domain;

import lotto.constant.ErrorMessage;

public class BonusNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
