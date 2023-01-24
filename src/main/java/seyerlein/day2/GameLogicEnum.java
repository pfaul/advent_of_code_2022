package seyerlein.day2;

import java.util.Arrays;
import java.util.Optional;

public enum GameLogicEnum
{
    LOOSE("X")
            {
                @Override
                public SymbolEnum getMySymbol(OpponentSymbolEnum opponentSymbol)
                {
                    switch (opponentSymbol)
                    {
                        case ROCK ->
                        {
                            return SymbolEnum.SCISSORS;
                        }
                        case PAPER ->
                        {
                            return SymbolEnum.ROCK;
                        }
                        case SCISSORS ->
                        {
                            return SymbolEnum.PAPER;
                        }
                    }
                    return null;
                }
            },
    DRAW("Y")
            {
                @Override
                public SymbolEnum getMySymbol(OpponentSymbolEnum opponentSymbol)
                {
                    switch (opponentSymbol)
                    {
                        case ROCK ->
                        {
                            return SymbolEnum.ROCK;
                        }
                        case PAPER ->
                        {
                            return SymbolEnum.PAPER;
                        }
                        case SCISSORS ->
                        {
                            return SymbolEnum.SCISSORS;
                        }
                    }
                    return null;
                }
            },
    WIN("Z")
            {
                @Override
                public SymbolEnum getMySymbol(OpponentSymbolEnum opponentSymbol)
                {
                    switch (opponentSymbol)
                    {
                        case ROCK ->
                        {
                            return SymbolEnum.PAPER;
                        }
                        case PAPER ->
                        {
                            return SymbolEnum.SCISSORS;
                        }
                        case SCISSORS ->
                        {
                            return SymbolEnum.ROCK;
                        }
                    }
                    return null;
                }
            };
    private final String value;

    GameLogicEnum(String value)
    {
        this.value = value;
    }

    public static Optional<GameLogicEnum> getInstance(String symbol)
    {
        return Arrays.stream(GameLogicEnum.values())
                .filter(e -> e.value.equalsIgnoreCase(symbol))
                .findFirst();
    }

    public abstract SymbolEnum getMySymbol(OpponentSymbolEnum opponentSymbol);
}
