package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.constant.ErrorMessage;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        return new BonusNumber(bonusNumber);
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateRange(bonusNumber);
        validateDuplication(bonusNumber, winningNumbers);
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
    }

    private static void validateDuplication(int numbers, List<Integer> winningNumbers) {
        if (winningNumbers.contains(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ERROR.getErrorMessage());
        }
    }

    public boolean isMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
