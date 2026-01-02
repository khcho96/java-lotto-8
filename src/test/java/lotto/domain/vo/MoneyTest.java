package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import lotto.constant.ErrorMessage;
import lotto.constant.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1500})
    void 구입_금액_단위_오류(int money) {
        assertThatThrownBy(() -> Money.from(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_UNIT_ERROR.getErrorMessage());
    }

    @Test
    void 구입_금액에_맞는_개수_반환() {
        Money money = Money.from(5000);
        assertThat(money.getLottoCount()).isEqualTo(5);
    }

    @Test
    void 수익률_계산_정수부분_세자리_이하() {
        Money money = Money.from(15000);
        Map<Rank, Integer> result = Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 1,
                Rank.FIFTH, 1
        );

        String profit = String.format("%,.1f", money.calculateProfit(result));
        assertThat(profit).isEqualTo("366.7");
    }

    @Test
    void 수익률_계산_정수부분_세자리_초과() {
        Money money = Money.from(15000);
        Map<Rank, Integer> result = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 1,
                Rank.FOURTH, 1,
                Rank.FIFTH, 1
        );

        String profit = String.format("%,.1f", money.calculateProfit(result));
        assertThat(profit).isEqualTo("13,543,700.0");
    }
}