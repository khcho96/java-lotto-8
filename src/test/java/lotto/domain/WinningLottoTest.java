package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 보너스_번호_중복_오류() {
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningLotto.registerBonusNumber(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR.getErrorMessage());
    }

    @Test
    void 보너스_번호_매칭_여부_반환() {
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        winningLotto.registerBonusNumber(7);

        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.isBonusMatch(lotto)).isTrue();
    }

    @Test
    void 매칭_개수_반환() {
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        winningLotto.registerBonusNumber(7);

        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.getMatchCount(lotto)).isEqualTo(5);
    }
}