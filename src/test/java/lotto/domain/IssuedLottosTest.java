package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class IssuedLottosTest {

    @Test
    void 로또_발행() {
        IssuedLottos issuedLottos = IssuedLottos.newInstance();

        issuedLottos.issue(List.of(1, 2, 3, 4, 5, 6));
        issuedLottos.issue(List.of(5, 12, 7, 41, 35, 1));

        List<List<Integer>> numbers = issuedLottos.getNumbers();

        assertThat(numbers.get(0)).containsExactlyElementsOf(List.of(1, 2, 3, 4, 5, 6));
        assertThat(numbers.get(1)).containsExactlyElementsOf(List.of(5, 12, 7, 41, 35, 1));
    }
}