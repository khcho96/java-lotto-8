package lotto.domain;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_UNIQUE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

import java.util.List;
import lotto.constant.core.Rank;

public class WinningLotto {
    private final Lotto winningLotto;
    private Integer bonusNumber;

    private WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static WinningLotto from(List<Integer> winningLottoNumber) {
        return new WinningLotto(new Lotto(winningLottoNumber));
    }

    public void registerBonusNumber(Integer bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberUnique(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (0 >= bonusNumber || bonusNumber > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    private void validateBonusNumberUnique(Integer bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_UNIQUE_ERROR.getErrorMessage());
        }
    }

    public Rank determineRank(Lotto issuedLotto) {
        Integer matchedCount = winningLotto.getMatchedCount(issuedLotto);
        if (matchedCount == 6) {
            return Rank.FIRST;
        }
        if (matchedCount == 5 && issuedLotto.contains(bonusNumber)) {
            return Rank.SECOND;
        }
        if (matchedCount == 5) {
            return Rank.THIRD;
        }
        if (matchedCount == 4) {
            return Rank.FOURTH;
        }
        if (matchedCount == 3) {
            return Rank.FIFTH;
        }
        return null;
    }
}
