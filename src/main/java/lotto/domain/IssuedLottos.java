package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lotto.dto.IssuedLottosDto;

public class IssuedLottos {

    private static IssuedLottos instance;
    private final List<Lotto> lottos;

    private IssuedLottos() {
        this.lottos = new ArrayList<>();
    }

    public static IssuedLottos getInstance() {
        if (instance == null) {
            instance = new IssuedLottos();
        }
        return instance;
    }

    public void add(List<Integer> lottoNumbers) {
        lottos.add(Lotto.from(lottoNumbers));
    }

    public IssuedLottosDto getIssuedLottos() {
        List<List<Integer>> issuedLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            issuedLottos.add(lotto.getNumbers());
        }
        return new IssuedLottosDto(issuedLottos);
    }

    public Iterator<Lotto> getIssuedLottosViewer() {
        return lottos.iterator();
    }

    public static void resetForTest() {
        instance = null;
    }
}
