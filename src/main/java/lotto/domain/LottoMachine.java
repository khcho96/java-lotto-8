package lotto.domain;

import java.util.List;
import lotto.generator.LottoGenerator;

public class LottoMachine {

    private final Integer lottoCount;

    private LottoMachine(PurchaseAmount purchaseAmount) {
        lottoCount = purchaseAmount.getLottoCount();
    }

    public static LottoMachine from(PurchaseAmount purchaseAmount) {
        return new LottoMachine(purchaseAmount);
    }

    public IssuedLottos generateLottos(LottoGenerator lottoGenerator) {
        IssuedLottos issuedLottos = IssuedLottos.getInstance();
        for (int count = 0; count < lottoCount; count++) {
            List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();
            issuedLottos.add(lottoNumbers);
        }
        return issuedLottos;
    }
}
