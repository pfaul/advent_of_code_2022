package seyerlein.day3;

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
    private static final String INPUT_FILE = "/day3/input.txt";

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
}