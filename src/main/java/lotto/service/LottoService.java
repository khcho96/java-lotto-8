package lotto.service;

import lotto.domain.LottoMachine;
import lotto.dto.IssuedLottosDto;

public class LottoService {
    public IssuedLottosDto issueLottos(Integer purchasedAmount) {
        LottoMachine lottoMachine = new LottoMachine(purchasedAmount);
        return lottoMachine.generateLottos();
    }
}
