package lotto.constant;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000, ""),
    SECOND(5, 30_000_000, ", 보너스 볼 일치"),
    THIRD(5, 1_500_000, ""),
    FOURTH(4, 50_000, ""),
    FIFTH(3, 5_000, ""),
    NONE(0, 2_000_000_000, ""),
    ;

    private final int matchedCount;
    private final long prize;
    private final String result;

    Rank(int matchedCount, long prize, String result) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.result = result;
    }

    public static Rank from(int matchedCount, boolean isBonusMatch) {
        if (matchedCount == 5) {
            if (isBonusMatch) return SECOND;
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchedCount == matchedCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public long getPrize() {
        return prize;
    }

    public String getResult() {
        return result;
    }
}
