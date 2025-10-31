package lotto.domain;

import java.util.List;
import lotto.dto.IssuedLottosDto;
import lotto.util.random.LottoGenerator;
import lotto.domain.vo.PurchaseAmount;

public class LottoMachine {

    private final PurchaseAmount purchaseAmount;
    private final Integer lottoCount;

    public LottoMachine(Integer purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        lottoCount = this.purchaseAmount.getLottoCount();
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
