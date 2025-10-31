package lotto.service;

import lotto.domain.LottoMachine;
import lotto.dto.IssuedLottosDto;
import lotto.util.random.RandomLottoGenerator;

public class LottoService {
    public IssuedLottosDto issueLottos(Integer purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        return lottoMachine.generateLottos(lottoGenerator);
    }
}
