package lotto.generator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void 랜덤_숫자_생성() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(NumberGenerator.generateNumbers())
                            .containsExactly(8, 21, 23, 41, 42, 43);
                    assertThat(NumberGenerator.generateNumbers())
                            .containsExactly(3, 5, 11, 16, 32, 38);
                    assertThat(NumberGenerator.generateNumbers())
                            .containsExactly(7, 11, 16, 35, 36, 44);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }
}