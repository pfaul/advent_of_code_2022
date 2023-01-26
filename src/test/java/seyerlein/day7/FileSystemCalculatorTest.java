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
    private static final String SAMPLE_INPUT_FILE = "/day7/sample_input.txt";

    @Test
    void testSample(@ListStringResource(SAMPLE_INPUT_FILE) List<String> inputLines)
    {
        FileSystemCalculator calculator = new FileSystemCalculator();
        Assertions.assertThat(calculator.getSumOfDirectories(inputLines)).isEqualTo(95437);
    }

    @Test
    void test(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        FileSystemCalculator calculator = new FileSystemCalculator();
        Assertions.assertThat(calculator.getSumOfDirectories(inputLines)).isEqualTo(1642503);
    }

    @Test
    void testDirToBeDeleted(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        //total disk size = 70000000
        //required space = 30000000

        //parent dir size = 46592386

        //required dir size to be deleted = 16592386
        FileSystemCalculator calculator = new FileSystemCalculator();
        Assertions.assertThat(calculator.getDirectorySizeToBeDeleted(inputLines)).isEqualTo(17187447);
    }
}