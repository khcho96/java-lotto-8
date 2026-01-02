package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private BonusNumber bonusNumber;

    private WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static WinningLotto from(List<Integer> winningNumbers) {
        return new WinningLotto(Lotto.from(winningNumbers));
    }
}
