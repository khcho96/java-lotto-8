package lotto.domain;

import lotto.domain.vo.Money;

public class LottoMachine {

    private Money money;
    private IssuedLottos issuedLottos;

    public static LottoMachine newInstance() {
        return new LottoMachine();
    }

    public void insertMoney(int money) {
        this.money = Money.from(money);
    }
}
