package lotto.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.constant.core.Rank;
import lotto.dto.LottoResultDto;

public class LottoResult {

    private final Map<Rank, Integer> lottoResult;
    private Double profitRate;

    private LottoResult() {
        lottoResult = new LinkedHashMap<>();
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.FIRST, 0);
    }

    public static LottoResult getInstance() {
        return new LottoResult();
    }

    public LottoResultDto getLottoResult(WinningLotto winningLotto, IssuedLottos issuedLottos) {
        calculateLottoResult(winningLotto, issuedLottos);
        calculateProfitRate();

        return new LottoResultDto(Collections.unmodifiableMap(lottoResult), profitRate);
    }

    private void calculateLottoResult(WinningLotto winningLotto, IssuedLottos issuedLottos) {
        Iterator<Lotto> issuedLottosViewer = issuedLottos.getIssuedLottosViewer();
        while (issuedLottosViewer.hasNext()) {
            Lotto issuedLotto = issuedLottosViewer.next();
            Rank rank = winningLotto.determineRank(issuedLotto);
            if (rank != null) {
                lottoResult.put(rank, lottoResult.get(rank) + 1);
            }
        }
    }

    private void calculateProfitRate() {
        Long profit = 0L;
        for (Rank rank : lottoResult.keySet()) {
            profit += rank.getPrize() * lottoResult.get(rank);
        }

        PurchaseAmount purchaseAmount = PurchaseAmount.getInstance();
        if (purchaseAmount != null) {
            profitRate = purchaseAmount.getProfitRate(profit);
        }
    }
}
