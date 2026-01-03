package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.Rank;
import lotto.dto.LottoResult;
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

    public static void printResult(LottoResult result) {
        Map<Rank, Integer> lottoResult = result.lottoResult();

        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Rank rank : lottoResult.keySet()) {
            System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                    rank.getMatchCount(),rank.getMessage(),rank.getPrice(), lottoResult.get(rank));
        }

        System.out.printf("총 수익률은 %,.1f%%입니다.\n", result.profit());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
