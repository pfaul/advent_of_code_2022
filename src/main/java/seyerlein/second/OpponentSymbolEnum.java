package seyerlein.second;

import java.util.Arrays;
import java.util.Optional;

public enum OpponentSymbolEnum
{
    ROCK("A"),
    PAPER("B"),
    SCISSORS("C");

    private final String symbol;

    OpponentSymbolEnum(String symbol)
    {
        this.symbol = symbol;
    }

    public static Optional<OpponentSymbolEnum> getInstance(String symbol){
        return Arrays.stream(OpponentSymbolEnum.values())
                .filter(e-> e.symbol.equalsIgnoreCase(symbol))
                .findFirst();
    }
}
