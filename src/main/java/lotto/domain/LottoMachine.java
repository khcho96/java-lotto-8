package lotto.domain;

import java.util.List;
import lotto.dto.IssuedLottosDto;
import lotto.util.random.LottoGenerator;
import lotto.domain.vo.PurchasedAmount;

public class LottoMachine {

    private final PurchasedAmount purchasedAmount;
    private final Integer lottoCount;

    public LottoMachine(Integer purchasedAmount) {
        this.purchasedAmount = new PurchasedAmount(purchasedAmount);
        lottoCount = this.purchasedAmount.getLottoCount();
    }

    public IssuedLottosDto generateLottos() {
        IssuedLottos issuedLottos = IssuedLottos.getInstance();
        for (int count = 0; count < lottoCount; count++) {
            List<Integer> lottoNumbers = LottoGenerator.generateLottoNumbers();
            issuedLottos.add(lottoNumbers);
        }
        return issuedLottos.getIssuedLottos();
    }
}
