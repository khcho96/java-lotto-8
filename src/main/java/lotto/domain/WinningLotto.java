package lotto.domain;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_UNIQUE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.core.Constant.FIFTH_RANK_MATCHED_COUNT;
import static lotto.constant.core.Constant.FIRST_RANK_MATCHED_COUNT;
import static lotto.constant.core.Constant.FOURTH_RANK_MATCHED_COUNT;
import static lotto.constant.core.Constant.LOTTO_NUMBER_MAX;
import static lotto.constant.core.Constant.LOTTO_NUMBER_MIN;
import static lotto.constant.core.Constant.SECOND_RANK_MATCHED_COUNT;
import static lotto.constant.core.Constant.THIRD_RANK_MATCHED_COUNT;

import java.util.List;
import lotto.constant.core.Rank;

public class WinningLotto {

    private final Lotto winningLotto;
    private Integer bonusNumber;

    private WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static WinningLotto from(List<Integer> winningLottoNumber) {
        return new WinningLotto(Lotto.from(winningLottoNumber));
    }

    public void registerBonusNumber(Integer bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberUnique(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (LOTTO_NUMBER_MIN > bonusNumber || bonusNumber > LOTTO_NUMBER_MAX) {
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
        if (matchedCount == FIRST_RANK_MATCHED_COUNT) {
            return Rank.FIRST;
        }
        if (matchedCount == SECOND_RANK_MATCHED_COUNT && issuedLotto.contains(bonusNumber)) {
            return Rank.SECOND;
        }
        if (matchedCount == THIRD_RANK_MATCHED_COUNT) {
            return Rank.THIRD;
        }
        if (matchedCount == FOURTH_RANK_MATCHED_COUNT) {
            return Rank.FOURTH;
        }
        if (matchedCount == FIFTH_RANK_MATCHED_COUNT) {
            return Rank.FIFTH;
        }
        return null;
    }
}
