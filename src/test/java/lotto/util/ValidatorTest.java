package lotto.util;

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
        assertThatThrownBy(()->Validator.validateNullOrBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
    }
}