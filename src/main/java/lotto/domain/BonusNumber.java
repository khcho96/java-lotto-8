package lotto.domain;

import lotto.constant.ErrorMessage;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }
}
