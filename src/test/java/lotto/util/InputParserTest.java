package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 숫자_파싱() {
        int number = InputParser.parseNumber("   3  ");
        assertThat(number).isEqualTo(3);
    }

    @Test
    void 쉼표_구분_문자열_파싱() {
        List<Integer> numbers = InputParser.parseCsvInput("1, 2, 3, 4, 5 ");
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5);
    }
}