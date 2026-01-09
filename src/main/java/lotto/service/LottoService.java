package lotto.service;

import java.util.List;
import lotto.domain.IssuedLotto;
import lotto.domain.LottoMachine;

public class LottoService {

    private LottoMachine lottoMachine;
    private IssuedLotto issuedLotto;
    private WinningLotto winningLotto;

    public void registerMoney(int money) {
        LottoMachine lottoMachine = LottoMachine.from(money);
    }

    public List<List<Integer>> issueLottos() {
        issuedLotto = lottoMachine.issueLottos();
        return issuedLotto.getLottos();
    }
}
