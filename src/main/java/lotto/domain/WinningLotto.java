package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.constant.Rank;

public class WinningLotto {

    private final Lotto winninLotto;
    private BonusNumber bonusNumber;

    private WinningLotto(Lotto winninLotto) {
        this.winninLotto = winninLotto;
    }

    public static WinningLotto of(Lotto winninLotto) {
        return new WinningLotto(winninLotto);
    }

    public void registerBonusNumber(int bonusNumber) {
        this.bonusNumber = BonusNumber.of(bonusNumber, winninLotto.getNumbers());
    }

    public LottoResult calculateResult(IssuedLotto issuedLotto) {
        List<Lotto> lottos = issuedLotto.getLottos();

        Map<Rank, Integer> lottoResult = calculateLottoResult(lottos);
        double profitRate = calculateProfitRate(lottoResult, lottos.size());

        return new LottoResult(lottoResult, profitRate);
    }

    private Map<Rank, Integer> calculateLottoResult(List<Lotto> lottos) {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = winninLotto.getMatchCount(lotto);
            boolean isBonusMatch = bonusNumber.isMatch(lotto);
            Rank rank = Rank.from(matchCount, isBonusMatch);
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
        return lottoResult;
    }

    private double calculateProfitRate(Map<Rank, Integer> lottoResult, int lottoCount) {
        int money = lottoCount * 1000;

        long sum = 0;
        for (Rank rank : lottoResult.keySet()) {
            sum += lottoResult.get(rank) * rank.getPrize();
        }

        return (double) sum / money * 100;
    }
}
