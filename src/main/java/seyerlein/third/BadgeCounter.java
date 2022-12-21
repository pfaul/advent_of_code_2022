package seyerlein.third;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BadgeCounter
{
    public int processInput(List<String> inputLines)
    {
        int sum = 0;
        for (int i = 0; i < inputLines.size(); i += 3)
        {
            String firstLine = inputLines.get(i);
            String secondLine = inputLines.get(i + 1);
            String thirdLine = inputLines.get(i + 2);

            Set<Character> matchesFirstSecondLine = new HashSet<>();
            for (char character : firstLine.toCharArray())
            {
                for (char secondCharacter : secondLine.toCharArray())
                {
                    if (secondCharacter == character)
                    {
                        matchesFirstSecondLine.add(character);
                    }
                }
            }
            for (Character matches : matchesFirstSecondLine)
            {
                for (char thirdCharacter : thirdLine.toCharArray())
                {
                    if (matches == thirdCharacter)
                    {
                        sum += CharacterEvaluator.charToInt(thirdCharacter);
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
