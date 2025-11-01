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
}
