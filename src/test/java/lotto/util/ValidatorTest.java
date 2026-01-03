package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 쉼표_구분_입력_오류() {
        assertThatThrownBy(() -> Validator.validateCsvFormat("1-2-3-4-5-6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }

    @Test
    void 쉼표_구분_입력_통과() {
        Validator.validateCsvFormat("1,2,3,4,8,9");
    }

    @Test
    void 숫자_입력_오류() {
        assertThatThrownBy(() -> Validator.validateNumberFormat("15a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }

    @Test
    void 숫자_입력_통과() {
        Validator.validateNumberFormat("12");
    }
}