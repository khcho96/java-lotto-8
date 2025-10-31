package lotto.domain.vo;

import static lotto.constant.ErrorMessage.PURCHASED_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASED_AMOUNT_UNIT_ERROR;

public class PurchasedAmount {

    private final Integer purchasedAmount;

    public PurchasedAmount(Integer purchasedAmount) {
        validateRange(purchasedAmount);
        validateUnit(purchasedAmount);
        this.purchasedAmount = purchasedAmount;
    }

    private void validateRange(Integer purchasedAmount) {
        if (0 >= purchasedAmount && purchasedAmount > 100000) {
            throw new IllegalArgumentException(PURCHASED_AMOUNT_RANGE_ERROR.getErrorMessage());
        }
    }

    private void validateUnit(Integer purchasedAmount) {
        if (purchasedAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASED_AMOUNT_UNIT_ERROR.getErrorMessage());
        }
    }

    public Integer getLottoCount() {
        return purchasedAmount / 1000;
    }
}
