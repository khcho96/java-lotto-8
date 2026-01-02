package lotto.dto;

import java.util.Map;
import lotto.constant.Rank;

public record LottoResult(Map<Rank, Integer> lottoResult, double profit) {

    public static LottoResult from(Map<Rank, Integer> lottoResult, double profit) {
        return new LottoResult(lottoResult, profit);
    }
}
