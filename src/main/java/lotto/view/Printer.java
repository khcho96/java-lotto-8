package lotto.view;

import lotto.dto.IssuedLottosDto;
import lotto.dto.LottoResultDto;

public class Printer {

    private static final String PURCHASED_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";

    public static void printPurchasedAmountRequest() {
        System.out.println(PURCHASED_AMOUNT_REQUEST);
    }

    public static void printWinningLottoRequest() {
        System.out.println(WINNING_LOTTO_REQUEST);
    }

    public static void printBonusNumberRequest() {
        System.out.println(BONUS_NUMBER_REQUEST);
    }

    public static void printIssuedLottos(IssuedLottosDto issuedLottosDto) {
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
