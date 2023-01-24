package seyerlein.day3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import seyerlein.ListStringResource;
import seyerlein.ListStringResourceExtension;

import java.util.List;

@ExtendWith(ListStringResourceExtension.class)
class BadgeCounterTest
{
    private static final String INPUT_FILE = "/day3/input.txt";

    @Test
    void test()
    {
        List<String> values = List.of("vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw");
        BadgeCounter counter = new BadgeCounter();
        Assertions.assertThat(counter.processInput(values)).isEqualTo(70);
    }

    @Test
    void testWithInput(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        BadgeCounter counter = new BadgeCounter();
        Assertions.assertThat(counter.processInput(inputLines)).isEqualTo(2650);
    }
}