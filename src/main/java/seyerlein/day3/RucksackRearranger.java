package seyerlein.day3;

import java.util.List;

public class RucksackRearranger
{
    public int processInput(List<String> inputLines)
    {
        int sum = 0;
        for (String line : inputLines)
        {
            int lengthHalf = line.length() / 2;
            String firstCompartment = line.substring(0, lengthHalf);
            String secondCompartment = line.substring(lengthHalf);

            boolean finished = false;
            for (char character : firstCompartment.toCharArray())
            {
                for (char secondChar : secondCompartment.toCharArray())
                {
                    if (secondChar == character)
                    {
                        sum += CharacterEvaluator.charToInt(character);
                        finished = true;
                        break;
                    }
                }
                if (finished)
                {
                    break;
                }
            }
        }
        return sum;
    }
}
