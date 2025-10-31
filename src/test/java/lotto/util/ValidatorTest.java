package lotto.util;

import static lotto.constant.ErrorMessage.CSV_FORMAT_ERROR;
import static lotto.constant.ErrorMessage.INPUT_NULL_OR_BLANK_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("입력값이 null 또는 빈 문자열이면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void 입력값이_null_또는_빈_문자열이면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> Validator.validateNullOrBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
    }

    @DisplayName("입력값이 쉼표로 구분된 정수 형식이 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {",1,2,3", "1,2,3,", ",1,2,3,", "1,,2", "1.2.3", "1|2|3"})
    void 입력값이_쉼표로_구분된_정수_형식이_아니면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> Validator.validateCsvFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CSV_FORMAT_ERROR.getErrorMessage());
    }
}
