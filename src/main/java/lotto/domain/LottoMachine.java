package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Rank;
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

    public LottoResult calculateResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        calculateResult(winningLotto, result);

        reflectRests(result);

        return LottoResult.from(result, money.getMoney());
    }

    private static void reflectRests(Map<Rank, Integer> result) {
        List<Rank> ranks = Arrays.stream(Rank.values()).filter(rank -> !rank.equals(Rank.NONE)).toList();
        for (Rank rank : ranks) {
            result.putIfAbsent(rank, 0);
        }
    }

    private void calculateResult(WinningLotto winningLotto, Map<Rank, Integer> result) {
        for (Lotto lotto : issuedLottos.getLottos()) {
            boolean isBonusMatch = winningLotto.isBonusMatch(lotto);
            int count = winningLotto.getMatchCount(lotto);

            Rank rank = Rank.of(count, isBonusMatch);

            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }
}
