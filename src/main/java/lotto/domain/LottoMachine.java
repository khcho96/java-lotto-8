package lotto.domain;

import java.util.List;
import lotto.dto.IssuedLottosDto;
import lotto.generator.LottoGenerator;

public class LottoMachine {

    private final Integer lottoCount;

    private LottoMachine(Integer purchaseAmount) {
        PurchaseAmount purchaseAmountObj = PurchaseAmount.from(purchaseAmount);
        lottoCount = purchaseAmountObj.getLottoCount();
    }

    public static LottoMachine from(Integer purchaseAmount) {
        return new LottoMachine(purchaseAmount);
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
