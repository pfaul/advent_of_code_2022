package seyerlein.day2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import seyerlein.ListStringResource;
import seyerlein.ListStringResourceExtension;

import java.util.List;

@ExtendWith(ListStringResourceExtension.class)
class RockPaperScissorsTest
{
    private static final String INPUT_FILE = "/day2/input.txt";

    @Test
    void test(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Assertions.assertThat(rockPaperScissors.calculateResult(inputLines)).isEqualTo(13268); //5990 = summe von X,Y,Z werten
    }

    @Test
    void test2(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Assertions.assertThat(rockPaperScissors.calculateResultPart2(inputLines)).isEqualTo(15508);
    }
}