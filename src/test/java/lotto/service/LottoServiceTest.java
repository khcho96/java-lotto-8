package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.LottoResult;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    void 서비스_정상_작동() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoService lottoService = new LottoService();

                    lottoService.registerMoney(3000);
                    lottoService.issueLottos();
                    lottoService.registerWinningLotto(List.of(8, 21, 23, 16, 32, 38));
                    lottoService.registerBonusNumber(7);

                    LottoResult lottoResult = lottoService.calculateResult();

                    String profit = String.format("%,.1f", lottoResult.profit());
                    assertThat(profit).isEqualTo("333.3");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }
}