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
}
