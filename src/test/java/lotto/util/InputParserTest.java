package lotto.util;

import static lotto.constant.ErrorMessage.CSV_FORMAT_ERROR;
import static lotto.constant.ErrorMessage.INPUT_NULL_OR_BLANK_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

    @DisplayName("구입 금액 입력값이 null 또는 빈 문자열이면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void 구입_금액_입력값이_null_또는_빈_문자열이면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> InputParser.parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
    }

    @DisplayName("구입 금액 입력값이 숫자 형식이 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"만원", "Two thousand won", "100 000"})
    void 구입_금액_입력값이_숫자_형식이_아니면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> InputParser.parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_FORMAT_ERROR.getErrorMessage());
    }

    @DisplayName("구입 금액 입력값 정수 변환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000,1000", "100000,100000", "0,0", "-1,-1", "100001,100001", "  2000  ,2000"})
    void 구입_금액_입력값_정수_변환_테스트(String input, Integer convertedValue) {
        // when
        Integer purchaseAmount = InputParser.parsePurchaseAmount(input);

        // then
        assertThat(purchaseAmount).isEqualTo(convertedValue);
    }

    @DisplayName("당첨 번호 입력값이 null 또는 빈 문자열이면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void 당첨_번호_입력값이_null_또는_빈_문자열이면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> InputParser.parseWinningLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
    }

    @DisplayName("당첨 번호 입력값이 쉼표로 구분된 정수 형식이 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {",1,2,3", "1,2,3,", ",-1,2,3,", "1,,2", "1.2.3", "1|2|3"})
    void 입력값이_쉼표로_구분된_정수_형식이_아니면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> InputParser.parseWinningLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CSV_FORMAT_ERROR.getErrorMessage());
    }

    @DisplayName("당첨 번호 입력값 쉼표 분리 테스트")
    @ParameterizedTest
    @MethodSource("csvArgumentProvider")
    void 당첨_번호_입력값_쉼표_분리_테스트(String input, List<Integer> winningLottoNumberResult) {
        // given, when
        List<Integer> winningLottoNumber = InputParser.parseWinningLottoNumber(input);

        // then
        assertThat(winningLottoNumber).containsExactlyElementsOf(winningLottoNumberResult);
    }

    static Stream<Arguments> csvArgumentProvider() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("   1,2,3,4,5,6   ", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("   1 , 2 , 3 , 4 , 5 , 6   ", List.of(1, 2, 3, 4, 5, 6))
        );
    }

    @DisplayName("보너스 번호 입력값이 null 또는 빈 문자열이면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void 보너스_번호_입력값이_null_또는_빈_문자열이면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> InputParser.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
    }

    @DisplayName("보너스 번호 입력값이 숫자 형식이 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"천", "Two thousand", "4 5"})
    void 보너스_번호_입력값이_숫자_형식이_아니면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> InputParser.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_FORMAT_ERROR.getErrorMessage());
    }

    @DisplayName("보너스 번호 입력값 정수 변환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"12,12", "0,0", "-1,-1", "46,46", "  12  ,12"})
    void 보너스_번호_입력값_정수_변환_테스트(String input, Integer convertedValue) {
        // when
        Integer purchaseAmount = InputParser.parseBonusNumber(input);

        // then
        assertThat(purchaseAmount).isEqualTo(convertedValue);
    }
}