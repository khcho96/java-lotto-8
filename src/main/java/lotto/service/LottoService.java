package lotto.service;

import java.util.List;
import lotto.domain.IssuedLottos;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.dto.IssuedLottosDto;
import lotto.dto.LottoResultDto;
import lotto.generator.RandomLottoGenerator;

public class LottoService {

    private WinningLotto winningLotto;
    private IssuedLottos issuedLottos;
    private PurchaseAmount purchaseAmount;

    public IssuedLottosDto issueLottos(Integer purchaseAmount) {
        this.purchaseAmount = PurchaseAmount.from(purchaseAmount);
        LottoMachine lottoMachine = LottoMachine.from(this.purchaseAmount);
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();

        issuedLottos = lottoMachine.generateLottos(lottoGenerator);
        return issuedLottos.getIssuedLottos();
    }

    public void registerWinningLottoNumber(List<Integer> winningLottoNumber) {
        winningLotto = WinningLotto.from(winningLottoNumber);
    }

    public void registerBonusNumber(Integer bonusNumber) {
        winningLotto.registerBonusNumber(bonusNumber);
    }

    public LottoResultDto getLottoResult() {
        LottoResult lottoResult = LottoResult.getInstance();

        return lottoResult.getLottoResult(winningLotto, issuedLottos, purchaseAmount);
    }
}
