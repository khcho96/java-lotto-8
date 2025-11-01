package lotto.random;

import java.util.List;

public class FixedLottoGenerator implements LottoGenerator {

    private final List<List<Integer>> lottoNumbers;

    public FixedLottoGenerator(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<Integer> generateLottoNumbers() {
        return lottoNumbers.removeFirst();
    }
}
