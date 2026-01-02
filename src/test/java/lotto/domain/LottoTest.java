package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.getErrorMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR.getErrorMessage());
    }

    @Test
    void 로또_번호_범위_오류() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
    }

    @Test
    void 보너스_번호_중복_확인() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isDuplicated(5)).isTrue();
    }

    @Test
    void 매칭_개수_반환() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = Lotto.from(List.of(1, 2, 12, 36, 5, 6));
        assertThat(winningLotto.getMatchCount(lotto)).isEqualTo(4);
    }
}
