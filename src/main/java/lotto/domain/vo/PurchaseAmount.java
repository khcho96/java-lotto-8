package lotto.domain.vo;

import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;

public class PurchaseAmount {

    private final Integer purchaseAmount;

    public PurchaseAmount(Integer purchaseAmount) {
        validateRange(purchaseAmount);
        validateUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateRange(Integer purchaseAmount) {
        if (0 >= purchaseAmount || purchaseAmount > 100000) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_RANGE_ERROR.getErrorMessage());
        }
    }

    private void validateUnit(Integer purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR.getErrorMessage());
        }
    }

    public Integer getLottoCount() {
        return purchaseAmount / 1000;
    }
}
