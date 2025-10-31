package lotto.view;

import java.util.List;
import lotto.dto.IssuedLottosDto;
import lotto.dto.LottoResultDto;

public class Printer {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";

    public static void printPurchaseAmountRequest() {
        System.out.println(PURCHASE_AMOUNT_REQUEST);
    }

    public static void printWinningLottoRequest() {
        System.out.println(WINNING_LOTTO_REQUEST);
    }

    public static void printBonusNumberRequest() {
        System.out.println(BONUS_NUMBER_REQUEST);
    }

    public static void printIssuedLottos(IssuedLottosDto issuedLottosDto) {
        List<List<Integer>> issuedLottos = issuedLottosDto.issuedLottos();
        System.out.println(NEW_LINE + issuedLottos.size() + "개를 구매했습니다.");
        for (List<Integer> issuedLotto : issuedLottos) {
            System.out.println(issuedLotto);
        }
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
