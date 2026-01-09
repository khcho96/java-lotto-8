package lotto.view;

import static java.util.Locale.KOREA;

import java.time.format.DateTimeFormatter;

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

    public static void printIssuedLotto() {
        System.out.printf("%d를 구매했습니다.\n");
        for (Object object : ) {

        }
        System.out.println();
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");

    }
}
