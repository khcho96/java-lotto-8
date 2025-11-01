package lotto.service;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.WinningLotto;
import lotto.dto.IssuedLottosDto;
import lotto.util.random.RandomLottoGenerator;

public class LottoService {

    private WinningLotto winningLotto;

    public IssuedLottosDto issueLottos(Integer purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        return lottoMachine.generateLottos(lottoGenerator);
    }

    public void registerWinningLottoNumber(List<Integer> winningLottoNumber) {
        winningLotto = WinningLotto.from(winningLottoNumber);
    }

    public void registerBonusNumber(Integer bonusNumber) {
        winningLotto.registerBonusNumber(bonusNumber);
    }
}
