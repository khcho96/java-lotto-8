package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.IssuedLottosDto;

public class IssuedLottos {

    private static IssuedLottos issuedLottosObj;
    private final List<Lotto> lottos;

    private IssuedLottos() {
        this.lottos = new ArrayList<>();
    }

    public static IssuedLottos getInstance() {
        if (issuedLottosObj == null) {
            issuedLottosObj = new IssuedLottos();
        }
        return issuedLottosObj;
    }

    public void add(List<Integer> lottoNumbers) {
        lottos.add(new Lotto(lottoNumbers));
    }

    public IssuedLottosDto getIssuedLottos() {
        List<List<Integer>> issuedLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            issuedLottos.add(lotto.getNumbers());
        }
        return new IssuedLottosDto(issuedLottos);
    }
}
