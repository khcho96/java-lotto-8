package lotto.domain;

import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;

public class PurchaseAmount {

    private static PurchaseAmount purchaseAmountObj;
    private final Integer purchaseAmount;

    private PurchaseAmount(Integer purchaseAmount) {
        validateRange(purchaseAmount);
        validateUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(Integer purchaseAmount) {
        if (purchaseAmountObj == null) {
            purchaseAmountObj = new PurchaseAmount(purchaseAmount);
        }
        return purchaseAmountObj;
    }

    public static PurchaseAmount getInstance() {
        return purchaseAmountObj;
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

    public Double getProfitRate(Long profit) {
        return (double) profit / purchaseAmount * 100;
    }

    public static void resetForTest() {          // package-private 권장
        purchaseAmountObj = null;
    }
}
