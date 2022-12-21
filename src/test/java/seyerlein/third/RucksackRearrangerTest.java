package seyerlein.third;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import seyerlein.ListStringResource;
import seyerlein.ListStringResourceExtension;

import java.util.List;

@ExtendWith(ListStringResourceExtension.class)
class RucksackRearrangerTest
{
    private static final String INPUT_FILE = "/third/input.txt";

    @Test
    void test(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        RucksackRearranger rearranger = new RucksackRearranger();
        Assertions.assertThat(rearranger.processInput(inputLines)).isEqualTo(1);
    }
}