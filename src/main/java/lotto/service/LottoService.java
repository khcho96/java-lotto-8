package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.domain.IssuedLotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

public class LottoService {

    private LottoMachine lottoMachine;
    private IssuedLotto issuedLotto;
    private WinningLotto winningLotto;

    public void registerMoney(int money) {
        lottoMachine = LottoMachine.from(money);
    }

    public List<List<Integer>> issueLottos() {
        issuedLotto = lottoMachine.issueLottos();
        return issuedLotto.getLottoNumbers();
    }

    public void registerWinningNumbers(List<Integer> numbers) {
        winningLotto = WinningLotto.of(Lotto.of(numbers));
    }

    public void registerBonusNumber(int bonusNumber) {
        winningLotto.registerBonusNumber(bonusNumber);
    }

    public LottoResult calculateResult() {
        return winningLotto.calculateResult(issuedLotto);
    }
}
