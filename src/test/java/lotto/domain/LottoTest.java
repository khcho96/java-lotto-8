package lotto.domain;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_UNIQUE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("countErrorArgumentProvider")
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> new Lotto(lottoNumber))
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

    @DisplayName("로또 번호의 범위가 알맞지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("rangeErrorArgumentProvider")
    void 로또_번호의_범위가_알맞지_않으면_예외가_발생한다(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> new Lotto(lottoNumber))
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

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_UNIQUE_ERROR.getErrorMessage());
    }

    @DisplayName("로또 번호 정상 반환 테스트")
    @Test
    void 로또_번호_정상_반환_테스트() {
        // given
        List<Integer> lottoNumber = new ArrayList<>(List.of(3, 2, 43, 16, 5, 1));

        // when
        Lotto lotto = new Lotto(lottoNumber);
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThat(numbers).containsExactly(1, 2, 3, 5, 16, 43);
    }

    @DisplayName("로또 번호 중복 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "7,false"})
    void 로또_번호_중복_테스트(Integer number, boolean value) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = lotto.contains(number);

        // then
        assertThat(result).isEqualTo(value);
    }

    @DisplayName("로또 번호 일치하는 개수 반환 테스트")
    @ParameterizedTest
    @MethodSource("MatchedCountArgumentProvider")
    void 로또_번호_일치하는_개수_반환_테스트(List<Integer> numbers, Integer expectedMatchedCount) {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        // when
        Integer matchedCount = winningLotto.getMatchedCount(lotto);

        // then
        assertThat(matchedCount).isEqualTo(expectedMatchedCount);
    }

    static Stream<Arguments> MatchedCountArgumentProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 8, 9, 10, 11, 12), 1),
                Arguments.of(List.of(1, 2, 9, 10, 11, 12), 2),
                Arguments.of(List.of(1, 2, 3, 10, 11, 12), 3),
                Arguments.of(List.of(1, 2, 3, 4, 11, 12), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 12), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }
}