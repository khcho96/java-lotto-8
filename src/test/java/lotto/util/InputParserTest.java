package lotto.util;

import static lotto.constant.ErrorMessage.INPUT_NULL_OR_BLANK_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @CsvSource(value = {"1000,1000", "100000,100000", "0,0", "-1,-1", "100001,100001"})
    void 구입_금액_입력값_정수_변환_테스트(String input, Integer convertedValue) {
        // when
        Integer purchaseAmount = InputParser.parsePurchaseAmount(input);

        // then
        assertThat(purchaseAmount).isEqualTo(convertedValue);
    }
}