package seyerlein.second;

import java.util.Arrays;
import java.util.Optional;

public enum SymbolEnum
{
    ROCK("X", 1),
    PAPER("Y", 2),
    SCISSORS("Z", 3);

    private final String symbol;
    private final int value;

    SymbolEnum(String symbol, int value)
    {
        this.symbol = symbol;
        this.value = value;
    }

    public static Optional<SymbolEnum> getInstance(String symbol){
        return Arrays.stream(SymbolEnum.values())
                .filter(e-> e.symbol.equalsIgnoreCase(symbol))
                .findFirst();
    }

    public String getSymbol()
    {
        return symbol;
    }

    public int getValue()
    {
        return value;
    }
}
