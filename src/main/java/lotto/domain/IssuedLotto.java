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
            numbers.add(Lotto.of(issuedLotto));
        }
        return new IssuedLotto(numbers);
    }

    public List<List<Integer>> getLottos() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .sorted()
                .toList();
    }
}
