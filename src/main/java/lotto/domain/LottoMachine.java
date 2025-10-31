package lotto.domain;

import lotto.vo.PurchasedAmount;

public class LottoMachine {

    private final PurchasedAmount purchasedAmount;
    private final Integer lottoCount;

    public LottoMachine(Integer purchasedAmount) {
        this.purchasedAmount = new PurchasedAmount(purchasedAmount);
        lottoCount = this.purchasedAmount.getLottoCount();
    }
}
