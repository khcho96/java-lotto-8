package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class IssuedLottos {

    private final List<Lotto> lottos;

    private IssuedLottos() {
        this.lottos = new ArrayList<>();
    }

    public static IssuedLottos newInstance() {
        return new IssuedLottos();
    }

    public void issue(List<Integer> numbers) {
        lottos.add(Lotto.from(numbers));
    }

    public List<List<Integer>> getNumbers() {
        List<List<Integer>> numbers = new ArrayList<>();

        for (Lotto lotto : lottos) {
            numbers.add(lotto.numbers());
        }

        return numbers;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
