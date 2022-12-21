package seyerlein.third;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CharacterEvaluator
{
    public static int charToInt(Character letter)
    {
        if (letter >= 'A' && letter <= 'Z')
        {
            return ((int) letter - 'A' + 27);
        }
        if (letter >= 'a' && letter <= 'z')
        {
            return ((int) letter - 'a' + 1);
        }
        return 0;
    }
}
