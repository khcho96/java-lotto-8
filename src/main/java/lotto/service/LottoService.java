package lotto.service;

import lotto.domain.LottoMachine;

public class LottoService {

    private LottoMachine lottoMachine;
    private IssuedLotto issuedLotto;
    private WinningLotto winningLotto;

    public void registerMoney(int money) {
        LottoMachine lottoMachine = LottoMachine.from(money);
    }
}
