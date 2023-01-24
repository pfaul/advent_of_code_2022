package seyerlein.day3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterEvaluatorTest
{
    @Test
    void testCharToInt()
    {
        String input = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray())
        {
            sb.append(CharacterEvaluator.charToInt(c));
        }
        Assertions.assertThat(sb.toString()).isEqualTo("12345678910111213141516171819202122232425262728293031323334353637383940414243444546474849505152");
    }

}