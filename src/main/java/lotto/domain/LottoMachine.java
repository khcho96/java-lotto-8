package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.dto.IssuedLottosDto;
import lotto.vo.PurchasedAmount;

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
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            issuedLottos.add(lottoNumbers);
        }
        return issuedLottos.getIssuedLottos();
    }
}
