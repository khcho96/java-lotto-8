package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_UNIQUE_ERROR;
import static lotto.constant.ErrorMessage.CSV_FORMAT_ERROR;
import static lotto.constant.ErrorMessage.INPUT_NULL_OR_BLANK_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_UNIQUE_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

    private final List<String> output = List.of(
            "8개를 구매했습니다.",
            "[8, 21, 23, 41, 42, 43]",
            "[3, 5, 11, 16, 32, 38]",
            "[7, 11, 16, 35, 36, 44]",
            "[1, 8, 11, 31, 41, 42]",
            "[13, 14, 16, 38, 42, 45]",
            "[7, 11, 30, 40, 42, 43]",
            "[2, 13, 22, 32, 38, 45]",
            "[1, 3, 5, 14, 22, 45]",
            "3개 일치 (5,000원) - 1개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 0개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
            "6개 일치 (2,000,000,000원) - 0개",
            "총 수익률은 62.5%입니다."
    );
    private final List<List<Integer>> input = List.of(
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44),
            List.of(1, 8, 11, 31, 41, 42),
            List.of(13, 14, 16, 38, 42, 45),
            List.of(7, 11, 30, 40, 42, 43),
            List.of(2, 13, 22, 32, 38, 45),
            List.of(1, 3, 5, 14, 22, 45)
    );

    @DisplayName("구입 금액 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"8000", "  8000  ", "\t8000\n"})
    void 구입_금액_정상_입력_테스트(String purchaseAmount) {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(purchaseAmount, "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            output
                    );
                },
                input.get(0),
                input.get(1),
                input.get(2),
                input.get(3),
                input.get(4),
                input.get(5),
                input.get(6),
                input.get(7)
        );
    }

    @DisplayName("당첨 번호 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "  1,2,3,4,5,6  ", " 1 , 2 , 3 , 4 , 5 , 6 ", "6,5,4,3,2,1"})
    void 당첨_번호_정상_입력_테스트(String winningLottoNumber) {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", winningLottoNumber, "7");
                    assertThat(output()).contains(
                            output
                    );
                },
                input.get(0),
                input.get(1),
                input.get(2),
                input.get(3),
                input.get(4),
                input.get(5),
                input.get(6),
                input.get(7)
        );
    }

    @DisplayName("보너스 번호 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"7", "  7  ", "\n7\t"})
    void 보너스_번호_정상_입력_테스트(String bonusNumber) {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", bonusNumber);
                    assertThat(output()).contains(
                            output
                    );
                },
                input.get(0),
                input.get(1),
                input.get(2),
                input.get(3),
                input.get(4),
                input.get(5),
                input.get(6),
                input.get(7)
        );
    }

    @DisplayName("구입 금액 입력 예외 테스트")
    @Nested
    class PurchaseAmountError {
        @DisplayName("빈 문자열이 입력되면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", "\t", "\n"})
        void 빈_문자열이_입력되면_예외가_발생한다(String purchaseAmount) {
            assertSimpleTest(() -> {
                runException(purchaseAmount);
                assertThat(output()).contains(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
            });
        }

        @DisplayName("숫자가 아닌 형식이 입력되면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"만원", "1000won"})
        void 숫자가_아닌_형식이_입력되면_예외가_발생한다(String purchaseAmount) {
            assertSimpleTest(() -> {
                runException(purchaseAmount);
                assertThat(output()).contains(NUMBER_FORMAT_ERROR.getErrorMessage());
            });
        }

        @DisplayName("구입 금액의 범위가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"-1", "0", "100001"})
        void 구입_금액의_범위가_아니면_예외가_발생한다(String purchaseAmount) {
            assertSimpleTest(() -> {
                runException(purchaseAmount);
                assertThat(output()).contains(PURCHASE_AMOUNT_RANGE_ERROR.getErrorMessage());
            });
        }

        @DisplayName("천원 단위가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1001", "1500", "12300"})
        void 천원_단위가_아니면_예외가_발생한다(String purchaseAmount) {
            assertSimpleTest(() -> {
                runException(purchaseAmount);
                assertThat(output()).contains(PURCHASE_AMOUNT_UNIT_ERROR.getErrorMessage());
            });
        }
    }

    @DisplayName("당첨 번호 입력 예외 테스트")
    @Nested
    class WinningLottoNumberError {
        @DisplayName("빈 문자열이 입력되면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", "\t", "\n"})
        void 빈_문자열이_입력되면_예외가_발생한다(String winningLottoNumber) {
            assertSimpleTest(() -> {
                runException("1000", winningLottoNumber);
                assertThat(output()).contains(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
            });
        }

        @DisplayName("당첨 번호 입력값이 쉼표로 구분돠는 형식이 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {",1,2,3", "1,2,3,", ",1,2,3,", "1,,2", "1.2.3", "1:2:3", "1|2|3"})
        void 당첨_번호_입력값이_쉼표로_구분되는_형식이_아니면_예외가_발생한다(String winningLottoNumber) {
            assertSimpleTest(() -> {
                runException("1000", winningLottoNumber);
                assertThat(output()).contains(CSV_FORMAT_ERROR.getErrorMessage());
            });
        }

        @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
        void 당첨_번호가_6개가_아니면_예외가_발생한다(String winningLottoNumber) {
            assertSimpleTest(() -> {
                runException("1000", winningLottoNumber);
                assertThat(output()).contains(LOTTO_NUMBER_COUNT_ERROR.getErrorMessage());
            });
        }

        @DisplayName("당첨 번호가 로또 번호의 범위가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,0", "1,2,3,4,5,46"})
        void 당첨_번호가_로또_번호의_범위가_아니면_예외가_발생한다(String winningLottoNumber) {
            assertSimpleTest(() -> {
                runException("1000", winningLottoNumber);
                assertThat(output()).contains(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
            });
        }

        @DisplayName("당첨 번호가 중복이면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,5"})
        void 당첨_번호가_중복이면_예외가_발생한다(String winningLottoNumber) {
            assertSimpleTest(() -> {
                runException("1000", winningLottoNumber);
                assertThat(output()).contains(LOTTO_NUMBER_UNIQUE_ERROR.getErrorMessage());
            });
        }
    }

    @DisplayName("보너스 번호 입력 예외 테스트")
    @Nested
    class BonusNumberError {
        @DisplayName("빈 문자열이 입력되면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", "\t", "\n"})
        void 빈_문자열이_입력되면_예외가_발생한다(String bonusNumber) {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", bonusNumber);
                assertThat(output()).contains(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
            });
        }

        @DisplayName("숫자 형식이 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"일", "삼", "two", "1000j"})
        void 숫자_형식이_아니면_예외가_발생한다(String bonusNumber) {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", bonusNumber);
                assertThat(output()).contains(NUMBER_FORMAT_ERROR.getErrorMessage());
            });
        }

        @DisplayName("보너스 번호가 로또 번호의 범위가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"-1", "0", "46"})
        void 보너스_번호가_로또_번호의_범위가_아니면_예외가_발생한다(String bonusNumber) {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", bonusNumber);
                assertThat(output()).contains(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
            });
        }

        @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1", "3", "5"})
        void 보너스_번호가_당첨_번호와_중복이면_예외가_발생한다(String bonusNumber) {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", bonusNumber);
                assertThat(output()).contains(BONUS_NUMBER_UNIQUE_ERROR.getErrorMessage());
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
