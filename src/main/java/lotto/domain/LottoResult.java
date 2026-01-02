package lotto.domain;

import java.util.Map;
import lotto.constant.Rank;

public record LottoResult(Map<Rank, Integer> lottoResult) {

    public static LottoResult from(Map<Rank, Integer> lottoResult, int money) {
        return new LottoResult(lottoResult);
    }
}
