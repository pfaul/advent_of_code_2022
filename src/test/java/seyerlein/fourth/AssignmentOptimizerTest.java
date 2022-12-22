package seyerlein.fourth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seyerlein.ListStringResource;
import seyerlein.ListStringResourceExtension;

import java.util.List;

@ExtendWith(ListStringResourceExtension.class)
class AssignmentOptimizerTest
{
    private static final String INPUT_FILE = "/fourth/input.txt";

    @Test
    void test(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        AssignmentOptimizer optimizer = new AssignmentOptimizer();
        Assertions.assertThat(optimizer.processInput(inputLines)).isEqualTo(424);
    }

    @ParameterizedTest
    @CsvSource(value = {"2-4,6-8,0",
            "2-3,4-5,0",
            "5-7,7-9,0",
            "2-8,3-7,1",
            "6-6,4-6,1",
            "2-6,4-8,0"})
    void testSample(String inputFirst, String inputSecond, int expectedResult)
    {
        AssignmentOptimizer optimizer = new AssignmentOptimizer();
        Assertions.assertThat(optimizer.processInput(List.of(inputFirst + "," + inputSecond))).isEqualTo(expectedResult);
    }
}