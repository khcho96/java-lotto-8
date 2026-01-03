package lotto.service;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.dto.LottoResult;
import lotto.domain.WinningLotto;
import lotto.dto.IssuedLottoResult;

public class LottoService {

    private LottoMachine lottoMachine;
    private WinningLotto winningLotto;

    public void registerMoney(int money) {
        lottoMachine = LottoMachine.newInstance();

        lottoMachine.insertMoney(money);
    }

    public IssuedLottoResult issueLottos() {
        lottoMachine.issueLottos();

        return lottoMachine.getIssuedLottos();
    }

    public void registerWinningLotto(List<Integer> winningNumbers) {
        winningLotto = WinningLotto.from(winningNumbers);
    }

    public void registerBonusNumber(int bonusNumber) {
        winningLotto.registerBonusNumber(bonusNumber);
    }

    public LottoResult calculateResult() {
        return lottoMachine.calculateResult(winningLotto);
    }
}
