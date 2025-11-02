package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.IssuedLottosDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IssuedLottosTest {

    @AfterEach
    void tearDown() {
        IssuedLottos.resetForTest();
    }

    @DisplayName("로또 생성 테스트")
    @Test
    void 로또_생성_테스트() {
        // given
        IssuedLottos issuedLottos = IssuedLottos.getInstance();

        // when
        issuedLottos.add(new ArrayList<>(List.of(6, 2, 3, 1, 5, 4)));
        issuedLottos.add(new ArrayList<>(List.of(5, 23, 12, 6, 8, 19)));
        issuedLottos.add(new ArrayList<>(List.of(34, 25, 21, 1, 4, 9)));
        issuedLottos.add(new ArrayList<>(List.of(14, 15, 41, 42, 30, 11)));
        IssuedLottosDto issuedLottosDto = issuedLottos.getIssuedLottos();
        List<List<Integer>> lottoNumbers = issuedLottosDto.issuedLottos();

        // then
        assertThat(lottoNumbers).containsExactly(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(5, 6, 8, 12, 19, 23),
                List.of(1, 4, 9, 21, 25, 34),
                List.of(11, 14, 15, 30, 41, 42)
        );
    }
}