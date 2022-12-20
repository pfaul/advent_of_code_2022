package seyerlein.second;

import java.util.List;
import java.util.Optional;

public class RockPaperScissors
{
    public int calculateResult(List<String> inputLines){
       return inputLines.stream()
                .map( s -> s.split("\s+"))
                .map( (String[] symbols )-> symbols[1])
                .map(SymbolEnum::getInstance)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(SymbolEnum::getValue)
                .reduce(0,Integer::sum);
    }
}
