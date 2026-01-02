package lotto.service;

import lotto.domain.LottoMachine;
import lotto.dto.IssuedLottoResult;

public class LottoService {

    private LottoMachine lottoMachine;

    public void registerMoney(int money) {
        lottoMachine = LottoMachine.newInstance();

        lottoMachine.insertMoney(money);
    }

    public IssuedLottoResult issueLottos() {
        lottoMachine.issueLottos();

        return lottoMachine.getIssuedLottos();
    }
}
