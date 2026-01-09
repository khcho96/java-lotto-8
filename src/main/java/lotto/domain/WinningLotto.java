package lotto.domain;

import lotto.Lotto;
import lotto.constant.ErrorMessage;

public class WinningLotto {

    private final Lotto winninLotto;
    private int bonusNumber;

    private WinningLotto(Lotto winninLotto) {
        this.winninLotto = winninLotto;
    }

    public static WinningLotto of(Lotto winninLotto) {
        return new WinningLotto(winninLotto);
    }

    public void registerBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
    }

    private void validateDuplication(int numbers) {
        if (winninLotto.getNumbers().contains(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ERROR.getErrorMessage());
        }
    }
}
