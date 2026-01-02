package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.IssuedLottoResult;
import lotto.dto.LottoResult;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 로또_발행() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoMachine lottoMachine = LottoMachine.newInstance();
                    lottoMachine.insertMoney(3000);
                    lottoMachine.issueLottos();

                    IssuedLottoResult issuedLottos = lottoMachine.getIssuedLottos();
                    List<List<Integer>> numbers = issuedLottos.numbers();

                    assertThat(issuedLottos.count()).isEqualTo(3);
                    assertThat(numbers.get(0)).containsExactlyElementsOf(List.of(8, 21, 23, 41, 42, 43));
                    assertThat(numbers.get(1)).containsExactlyElementsOf(List.of(3, 5, 11, 16, 32, 38));
                    assertThat(numbers.get(2)).containsExactlyElementsOf(List.of(7, 11, 16, 35, 36, 44));
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Test
    void 로또_발행_및_결과_반환() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoMachine lottoMachine = LottoMachine.newInstance();
                    lottoMachine.insertMoney(3000);
                    lottoMachine.issueLottos();

                    WinningLotto winningLotto = WinningLotto.from(List.of(8, 21, 23, 32, 38, 5));
                    winningLotto.registerBonusNumber(45);

                    LottoResult lottoResult = lottoMachine.calculateResult(winningLotto);

                    String profit = String.format("%,.1f", lottoResult.profit());
                    assertThat(profit).isEqualTo("333.3");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }
}