package lotto.domain.vo;

import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("구매 금액 입력값이 알맞은 범위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 100001})
    void 구매_금액_입력값이_알맞은_범위가_아니면_예외가_발생한다(Integer purchaseAmount) {
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_RANGE_ERROR.getErrorMessage());
    }

    @DisplayName("구매 금액 입력값이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 17300, 25220, 99999})
    void 구매_금액_입력값이_1000원_단위가_아니면_예외가_발생한다(Integer purchaseAmount) {
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_UNIT_ERROR.getErrorMessage());
    }

    @DisplayName("발행 로또 개수 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "15000,15", "100000,100"})
    void 발행_로또_개수_반환_테스트(Integer purchaseAmount, Integer count) {
        // given
        PurchaseAmount purchaseAmountObj = new PurchaseAmount(purchaseAmount);

        // when
        Integer lottoCount = purchaseAmountObj.getLottoCount();
        assertThat(lottoCount).isEqualTo(count);
    }
}