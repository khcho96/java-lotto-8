package lotto.dto;

import java.util.Map;
import lotto.constant.core.Rank;

public record LottoResultDto(Map<Rank, Integer> lottoResult, Double profitRate) {
}
