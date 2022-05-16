package lotto.model;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(Long countOfMatch, boolean matchBonus) {
        return valueOf(countOfMatch.intValue(), matchBonus);
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank rank = Stream.of(Rank.values())
                .filter(value -> value.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);

        if (rank == Rank.SECOND && !matchBonus) {
            return Rank.THIRD;
        }

        return rank;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
