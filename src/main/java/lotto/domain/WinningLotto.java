package lotto.domain;

import java.util.List;
import lotto.constant.ErrorMessage;

public class WinningLotto {

    private final Lotto winningLotto;
    private BonusNumber bonusNumber;

    private WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static WinningLotto from(List<Integer> winningNumbers) {
        return new WinningLotto(Lotto.from(winningNumbers));
    }

    public void registerBonusNumber(int bonusNumber) {
        validateBonusNumberDuplication(bonusNumber);
        this.bonusNumber = BonusNumber.from(bonusNumber);
    }

    private void validateBonusNumberDuplication(int bonusNumber) {
        if (winningLotto.isDuplicated(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR.getErrorMessage());
        }
    }
}
