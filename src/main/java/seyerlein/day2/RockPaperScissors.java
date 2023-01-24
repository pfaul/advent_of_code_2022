package seyerlein.day2;

import java.util.List;

public class RockPaperScissors
{
    public int calculateResult(List<String> inputLines)
    {
        return inputLines.stream()
                .map(s -> s.split("\s+"))
                .map((String[] symbols) -> {
                    OpponentSymbolEnum opponentSymbol = OpponentSymbolEnum.getInstance(symbols[0]).orElseThrow();
                    SymbolEnum symbol = SymbolEnum.getInstance(symbols[1]).orElseThrow();
                    return symbol.calculateResult(opponentSymbol) + symbol.getValue();
                })
                .reduce(0, Integer::sum);
    }

    public int calculateResultPart2(List<String> inputLines)
    {
        return inputLines.stream()
                .map(s -> s.split("\s+"))
                .map((String[] symbols) -> {
                    OpponentSymbolEnum opponentSymbol = OpponentSymbolEnum.getInstance(symbols[0]).orElseThrow();
                    GameLogicEnum gameLogicEnum = GameLogicEnum.getInstance(symbols[1]).orElseThrow();
                    SymbolEnum symbol = gameLogicEnum.getMySymbol(opponentSymbol);
                    return symbol.calculateResult(opponentSymbol) + symbol.getValue();
                })
                .reduce(0, Integer::sum);
    }
}
