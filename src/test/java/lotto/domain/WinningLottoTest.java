package lotto.domain;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_UNIQUE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_UNIQUE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.constant.core.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {
    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("countErrorArgumentProvider")
    void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> WinningLotto.from(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_COUNT_ERROR.getErrorMessage());
    }

    static Stream<Arguments> countErrorArgumentProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1))
        );
    }

    @DisplayName("당첨 번호의 범위가 알맞지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("rangeErrorArgumentProvider")
    void 당첨_번호의_범위가_알맞지_않으면_예외가_발생한다(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> WinningLotto.from(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
    }

    static Stream<Arguments> rangeErrorArgumentProvider() {
        return Stream.of(
                Arguments.of(List.of(-1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 46, 4, 5, 6)),
                Arguments.of(List.of(0, 1, 2, 4, 6, 7))
        );
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_UNIQUE_ERROR.getErrorMessage());
    }

    @DisplayName("보너스 번호의 범위가 알맞지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스_번호의_범위가_알맞지_않으면_예외가_발생한다(Integer bonusNumber) {
        // given
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));

        // when then
        assertThatThrownBy(() -> winningLotto.registerBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복이면_예외가_발생한다() {
        // given
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));

        // when then
        assertThatThrownBy(() -> winningLotto.registerBonusNumber(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_UNIQUE_ERROR.getErrorMessage());
    }

    @DisplayName("발행된 로또 번호의 등수 반환 테스트")
    @ParameterizedTest
    @MethodSource("rankArgumentProvider")
    void 발행된_로또_번호의_등수_반환_테스트(List<Integer> numbers, Rank expectedRank) {
        // given
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        winningLotto.registerBonusNumber(7);
        Lotto lotto = new Lotto(numbers);

        // when
        Rank rank = winningLotto.determineRank(lotto);

        // then
        assertThat(rank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> rankArgumentProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 8, 9, 10, 11, 12), null),
                Arguments.of(List.of(1, 2, 9, 10, 11, 12), null),
                Arguments.of(List.of(1, 2, 3, 10, 11, 12), Rank.FIFTH),
                Arguments.of(List.of(1, 2, 3, 4, 11, 12), Rank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 12), Rank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST)
        );
    }
}