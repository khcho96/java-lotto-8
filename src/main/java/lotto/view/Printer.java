package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.core.Rank;
import lotto.dto.IssuedLottosDto;
import lotto.dto.LottoResultDto;

public class Printer {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_RESULT = "%d개를 구매했습니다.";
    private static final String WINNING_RESULT = "당첨 통계" + NEW_LINE + "---";
    private static final String PROFIT_RATE_RESULT = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseAmountRequest() {
        System.out.println(NEW_LINE + PURCHASE_AMOUNT_REQUEST);
    }

    public static void printWinningLottoRequest() {
        System.out.println(NEW_LINE + WINNING_LOTTO_REQUEST);
    }

    public static void printBonusNumberRequest() {
        System.out.println(NEW_LINE + BONUS_NUMBER_REQUEST);
    }

    public static void printIssuedLottos(IssuedLottosDto issuedLottosDto) {
        List<List<Integer>> issuedLottos = issuedLottosDto.issuedLottos();

        System.out.printf(NEW_LINE + LOTTO_COUNT_RESULT + NEW_LINE, issuedLottos.size());
        for (List<Integer> issuedLotto : issuedLottos) {
            System.out.println(issuedLotto);
        }
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
        Map<Rank, Integer> lottoResult = lottoResultDto.lottoResult();

        System.out.println(NEW_LINE + WINNING_RESULT);
        for (Rank rank : lottoResult.keySet()) {
            System.out.printf(rank.getPrintedContents() + NEW_LINE, lottoResult.get(rank));
        }
        System.out.printf(PROFIT_RATE_RESULT + NEW_LINE, lottoResultDto.profitRate());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
