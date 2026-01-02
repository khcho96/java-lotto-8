package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스번호_범위_오류(int number) {
        assertThatThrownBy(() -> BonusNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void 보너스번호_범위_정상(int number) {
        BonusNumber.from(number);
    }
}