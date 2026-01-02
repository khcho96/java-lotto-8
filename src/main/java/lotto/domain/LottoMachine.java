package lotto.domain;

import java.util.List;
import lotto.domain.vo.Money;
import lotto.dto.IssuedLottoResult;
import lotto.generator.NumberGenerator;

public class LottoMachine {

    private Money money;
    private IssuedLottos issuedLottos;

    public static LottoMachine newInstance() {
        return new LottoMachine();
    }

    public void insertMoney(int money) {
        this.money = Money.from(money);
    }

    public void issueLottos() {
        issuedLottos = IssuedLottos.newInstance();

        for (int i = 0; i < money.getLottoCount(); i++) {
            List<Integer> numbers = NumberGenerator.generateNumbers();

            issuedLottos.issue(numbers);
        }
    }

    public IssuedLottoResult getIssuedLottos() {
        return IssuedLottoResult.of(money.getLottoCount(), issuedLottos.getNumbers());
    }
}
