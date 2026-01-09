package lotto.view;

import static java.util.Locale.KOREA;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.constant.Rank;
import lotto.domain.LottoResult;

public final class OutputView {

    private static final DateTimeFormatter DATETIME_FMT =
            DateTimeFormatter.ofPattern("M월 dd일 E요일 HH:mm", KOREA);
    private static final DateTimeFormatter DATE_FMT =
            DateTimeFormatter.ofPattern("M월 dd일 E요일", KOREA);
    private static final DateTimeFormatter TIME_FMT =
            DateTimeFormatter.ofPattern("HH:mm", KOREA);

    private OutputView() {
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printIssuedLotto(List<List<Integer>> issuedLottos) {
        System.out.printf("%d를 구매했습니다.\n", issuedLottos.size());
        for (List<Integer> numbers : issuedLottos) {
            System.out.println(numbers);
        }
        System.out.println();
    }

    public static void printResult(LottoResult lottoResult) {
        Map<Rank, Integer> result = lottoResult.lottoResult();
        double profitRate = lottoResult.profitRate();

        System.out.println("당첨 통계");
        System.out.println("---");
        List<Rank> ranks = Arrays.stream(Rank.values())
                .sorted(Comparator.comparingLong(Rank::getPrize).reversed())
                .toList();
        for (Rank rank : ranks) {
            if (rank.equals(Rank.NONE)) {
                continue;
            }

            if (result.containsKey(rank)) {
                System.out.printf("%d개 일치%s (%,d원) - %d개\n",
                        rank.getMatchedCount(), rank.getResult(), rank.getPrize(), result.get(rank));
            }
            System.out.printf("%d개 일치%s (%,d원) - 0개\n",
                    rank.getMatchedCount(), rank.getResult(), rank.getPrize());
        }
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", profitRate);
    }
}
