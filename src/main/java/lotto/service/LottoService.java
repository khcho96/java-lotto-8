package lotto.service;

import java.util.List;
import lotto.domain.IssuedLottos;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.dto.IssuedLottosDto;
import lotto.dto.LottoResultDto;
import lotto.generator.RandomLottoGenerator;

public class LottoService {

    private WinningLotto winningLotto;

    public IssuedLottosDto issueLottos(Integer purchaseAmount) {
        LottoMachine lottoMachine = LottoMachine.from(purchaseAmount);
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();

        return lottoMachine.generateLottos(lottoGenerator);
    }

    public void registerWinningLottoNumber(List<Integer> winningLottoNumber) {
        winningLotto = WinningLotto.from(winningLottoNumber);
    }

    public void registerBonusNumber(Integer bonusNumber) {
        winningLotto.registerBonusNumber(bonusNumber);
    }

    public LottoResultDto getLottoResult() {
        IssuedLottos issuedLottos = IssuedLottos.getInstance();
        LottoResult lottoResult = LottoResult.getInstance();

        return lottoResult.getLottoResult(winningLotto, issuedLottos);
    }
}
