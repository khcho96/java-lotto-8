package lotto.view;

import java.util.List;
import lotto.dto.IssuedLottoResult;

public class OutputView {

    private OutputView() {
    }

    public static void printIssuedLottos(IssuedLottoResult issuedLottoResult) {
        System.out.printf("\n%d개를 구매했습니다.\n", issuedLottoResult.count());
        for (List<Integer> number : issuedLottoResult.numbers()) {
            number.sort(null);
            System.out.println(number);
        }
    }

    public static void printResult() {

    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
