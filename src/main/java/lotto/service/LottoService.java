package lotto.service;

import lotto.domain.LottoMachine;

public class LottoService {

    public void registerMoney(int money) {
        LottoMachine lottoMachine = LottoMachine.newInstance();

        lottoMachine.insertMoney(money);
    }
}
