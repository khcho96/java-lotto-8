package lotto.domain;

import lotto.Lotto;

public class WinningLotto {

    private final Lotto winninLotto;
    private int BonusNumber;

    private WinningLotto(Lotto winninLotto) {
        this.winninLotto = winninLotto;
    }

    public static WinningLotto of(Lotto winninLotto) {
        return new WinningLotto(winninLotto);
    }
}
