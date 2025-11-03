package lotto.domain;

import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("구매 금액 입력값이 알맞은 범위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 100001})
    void 구매_금액_입력값이_알맞은_범위가_아니면_예외가_발생한다(Integer purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmount.from(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_RANGE_ERROR.getErrorMessage());
    }

    @DisplayName("구매 금액 입력값이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 17300, 25220, 99999})
    void 구매_금액_입력값이_1000원_단위가_아니면_예외가_발생한다(Integer purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmount.from(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_UNIT_ERROR.getErrorMessage());
    }

    @DisplayName("발행 로또 개수 반환 테스트")
    @Test
    void 발행_로또_개수_반환_테스트() {
        // given
        PurchaseAmount purchaseAmountObj = PurchaseAmount.from(1000);

        // when
        Integer lottoCount = purchaseAmountObj.getLottoCount();

        // then
        assertThat(lottoCount).isEqualTo(1);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void 수익률_계산_테스트() {
        // given
        PurchaseAmount purchaseAmountObj = PurchaseAmount.from(20000);

        // when
        Double profitRate = purchaseAmountObj.getProfitRate(5000L);

        // then
        assertThat(profitRate).isEqualTo(25);
    }
}