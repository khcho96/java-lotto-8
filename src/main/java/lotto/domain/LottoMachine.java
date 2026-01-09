package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.generator.RandomLottoNumberGenerator;

public class LottoMachine {

    private final Money money;

    private LottoMachine(Money money) {
        this.money = money;
    }

    public static LottoMachine from(int money) {
        return new LottoMachine(Money.from(money));
    }

    public IssuedLotto issueLottos() {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < money.getCount(); i++) {
            lottos.add(RandomLottoNumberGenerator.generateLottoNumbers());
        }
        return IssuedLotto.from(lottos);
    }
}
