package lotto.domain;

import java.util.Map;
import lotto.constant.Rank;

public record LottoResult(Map<Rank, Integer> lottoResult, double profitRate) {
}
