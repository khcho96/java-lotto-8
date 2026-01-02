package lotto.domain;

import lotto.constant.ErrorMessage;

public record BonusNumber(int bonusNumber) {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public BonusNumber {
        validateRange(bonusNumber);
    }

    public static BonusNumber from(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }
}
