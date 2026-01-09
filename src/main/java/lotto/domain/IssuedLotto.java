package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class IssuedLotto {

    private final List<Lotto> lottos;

    private IssuedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static IssuedLotto from(List<List<Integer>> issuedLottos) {
        List<Lotto> numbers = new ArrayList<>();
        for (List<Integer> issuedLotto : issuedLottos) {
            issuedLotto.sort(null);
            numbers.add(Lotto.of(issuedLotto));
        }
        return new IssuedLotto(numbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
