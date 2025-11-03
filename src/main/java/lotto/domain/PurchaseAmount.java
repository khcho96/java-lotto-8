package lotto.domain;

import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;
import static lotto.constant.core.Constant.PURCHASE_AMOUNT_MAX;
import static lotto.constant.core.Constant.PURCHASE_AMOUNT_MIN;
import static lotto.constant.core.Constant.PURCHASE_AMOUNT_UNIT;

public class PurchaseAmount {

    private final Integer purchaseAmount;

    private PurchaseAmount(Integer purchaseAmount) {
        validateRange(purchaseAmount);
        validateUnit(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(Integer purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validateRange(Integer purchaseAmount) {
        if (PURCHASE_AMOUNT_MIN >= purchaseAmount || purchaseAmount > PURCHASE_AMOUNT_MAX) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_RANGE_ERROR.getErrorMessage());
        }
    }

    private void validateUnit(Integer purchaseAmount) {
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR.getErrorMessage());
        }
    }

    public Integer getLottoCount() {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }

    public Double getProfitRate(Long profit) {
        return (double) profit / purchaseAmount * 100;
    }
}
