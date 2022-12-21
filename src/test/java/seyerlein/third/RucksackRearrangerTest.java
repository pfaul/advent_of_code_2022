package seyerlein.third;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seyerlein.ListStringResource;
import seyerlein.ListStringResourceExtension;

import java.util.List;

@ExtendWith(ListStringResourceExtension.class)
class RucksackRearrangerTest
{
    private static final String INPUT_FILE = "/third/input.txt";

    @ParameterizedTest
    @CsvSource(value = {"abcaAA,1",
            "aa,1",
            "bbbb,2",
            "vJrwpWtwJgWrhcsFMMfFFhFp,16",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL,38",
            "PmmdzqPrVvPwwTWBwg,42",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn,22",
            "ttgJtRGJQctTZtZT,20",
            "CrZsJsPPZsGzwwsLwLmpwMDw,19"})
    void testWithExample(String input, int expectedResult)
    {
        List<String> inputLines = List.of(input);
        RucksackRearranger rearranger = new RucksackRearranger();
        Assertions.assertThat(rearranger.processInput(inputLines)).isEqualTo(expectedResult);
    }

    @Test
    void testWithInput(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        RucksackRearranger rearranger = new RucksackRearranger();
        Assertions.assertThat(rearranger.processInput(inputLines)).isEqualTo(7428);
    }

    @Test
    void testCharToInt()
    {
        RucksackRearranger rearranger = new RucksackRearranger();
        String input = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray())
        {
            sb.append(rearranger.charToInt(c));
        }
        Assertions.assertThat(sb.toString()).isEqualTo("12345678910111213141516171819202122232425262728293031323334353637383940414243444546474849505152");
    }
}