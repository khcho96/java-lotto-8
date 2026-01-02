package lotto.constant;

import java.util.Arrays;

public enum Rank implements Comparable<Rank> {

    FIFTH(3, "", 5_000, false),
    FOURTH(4, "", 50_000, false),
    THIRD(5, "", 1_500_000, false),
    SECOND(5, ", 보너스 볼 일치", 30_000_000, true),
    FIRST(6, "", 2_000_000_000, false),
    NONE(0, "", 0, false),
    ;

    private final int matchCount;
    private final String message;
    private final long price;
    private final boolean isBonus;

    Rank(int matchCount, String message, long price, boolean isBonus) {
        this.matchCount = matchCount;
        this.message = message;
        this.price = price;
        this.isBonus = isBonus;
    }

    public static Rank of(int matchCount, boolean isBonus) {
        if (matchCount == 5) {
            return Arrays.stream(values())
                    .filter(rank -> rank.matchCount == matchCount)
                    .filter(rank -> rank.isBonus == isBonus)
                    .findFirst()
                    .orElse(NONE);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }

    public long getPrice() {
        return price;
    }


}
