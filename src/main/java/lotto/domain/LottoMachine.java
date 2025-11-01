package lotto.domain;

import java.util.List;
import lotto.dto.IssuedLottosDto;
import lotto.util.random.LottoGenerator;

public class LottoMachine {

    private final Integer lottoCount;

    public LottoMachine(Integer purchaseAmount) {
        PurchaseAmount purchaseAmountObj = PurchaseAmount.from(purchaseAmount);
        lottoCount = purchaseAmountObj.getLottoCount();
    }

    public IssuedLottosDto generateLottos(LottoGenerator lottoGenerator) {
        IssuedLottos issuedLottos = IssuedLottos.getInstance();
        for (int count = 0; count < lottoCount; count++) {
            List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();
            issuedLottos.add(lottoNumbers);
        }
        return issuedLottos.getIssuedLottos();
    }
}
