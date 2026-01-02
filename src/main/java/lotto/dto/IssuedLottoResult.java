package lotto.dto;

import java.util.List;

public record IssuedLottoResult(int count, List<List<Integer>> numbers) {
    public static IssuedLottoResult of(int count, List<List<Integer>> numbers) {
        return new IssuedLottoResult(count, numbers);
    }
}
