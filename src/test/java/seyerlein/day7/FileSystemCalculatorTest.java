package seyerlein.day7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import seyerlein.ListStringResource;
import seyerlein.ListStringResourceExtension;

import java.util.List;

@ExtendWith(ListStringResourceExtension.class)
class FileSystemCalculatorTest
{
    private static final String INPUT_FILE = "/day7/input.txt";

    @Test
    void test(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        FileSystemCalculator calculator = new FileSystemCalculator();
        Assertions.assertThat(calculator.getSumOfTotalFiles(inputLines)).isEqualTo(1);
    }
}