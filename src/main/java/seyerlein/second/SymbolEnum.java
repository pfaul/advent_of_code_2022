package seyerlein.second;

import java.util.Arrays;
import java.util.Optional;

public enum SymbolEnum
{
    ROCK("X", 1){
        @Override
        public int calculateResult(OpponentSymbolEnum opponentSymbol)
        {
            switch (opponentSymbol){
                case ROCK -> {return 3;}
                case PAPER -> {return 0;}
                case SCISSORS -> {return 6;}
            }
            return 0;
        }
    },
    PAPER("Y", 2)
            {
                @Override
                public int calculateResult(OpponentSymbolEnum opponentSymbol)
                {
                    switch (opponentSymbol){
                        case ROCK -> {return 6;}
                        case PAPER -> {return 3;}
                        case SCISSORS -> {return 0;}
                    }
                    return 0;
                }
            },
    SCISSORS("Z", 3)
            {
                @Override
                public int calculateResult(OpponentSymbolEnum opponentSymbol)
                {

                    switch (opponentSymbol){
                        case ROCK -> {return 0;}
                        case PAPER -> {return 6;}
                        case SCISSORS -> {return 3;}
                    }
                    return 0;
                }
            };

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

    public abstract int calculateResult(OpponentSymbolEnum opponentSymbol);
}
