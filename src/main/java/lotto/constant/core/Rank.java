package lotto.constant.core;

public enum Rank {
    FIRST(2000000000L, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(1500000L, "5개 일치 (1,500,000원) - %d개"),
    FOURTH( 50000L, "4개 일치 (50,000원) - %d개"),
    FIFTH(5000L, "3개 일치 (5,000원) - %d개");

    private final Long prize;
    private final String printedContents;

    Rank(Long prize, String printedContents) {
        this.prize = prize;
        this.printedContents = printedContents;
    }

    public Long getPrize() {
        return prize;
    }

    public String getPrintedContents() {
        return printedContents;
    }
}
