package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.IssuedLottosDto;
import lotto.generator.FixedLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("로또 발행 테스트")
    @Test
    void 로또_발행_테스트() {
        // given
        List<List<Integer>> lottoNumbers = List.of(
                List.of(41, 23, 11, 1, 15, 16),
                List.of(14, 5, 32, 31, 40, 41),
                List.of(1, 10, 45, 39, 21, 11),
                List.of(13, 1, 9, 8, 15, 30),
                List.of(4, 41, 23, 12, 13, 45)
                );

        Integer purchasedAmount = 5000;
        LottoMachine lottoMachine = LottoMachine.from(PurchaseAmount.from(purchasedAmount));

        // when
        IssuedLottos issuedLottos = lottoMachine.generateLottos(new FixedLottoGenerator(lottoNumbers));
        IssuedLottosDto issuedLottosDto = issuedLottos.getIssuedLottos();
        List<List<Integer>> issuedLottosResult = issuedLottosDto.issuedLottos();

        // then
        assertThat(issuedLottosResult).containsExactly(
                List.of(1, 11, 15, 16, 23, 41),
                List.of(5, 14, 31, 32, 40, 41),
                List.of(1, 10, 11, 21, 39, 45),
                List.of(1, 8, 9, 13, 15, 30),
                List.of(4, 12, 13, 23, 41, 45)
        );
    }
}