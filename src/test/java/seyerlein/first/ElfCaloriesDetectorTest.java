package seyerlein.first;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import seyerlein.ListStringResource;
import seyerlein.ListStringResourceExtension;

import java.util.List;

@ExtendWith(ListStringResourceExtension.class)
class ElfCaloriesDetectorTest
{
    private static final String INPUT_FILE = "/first/input.txt";

    @Test
    void testFindElf(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        ElfCaloriesDetector detector = new ElfCaloriesDetector();
        Assertions.assertThat(detector.findElfWithMostCalories(inputLines)).isEqualTo(new Elf(229, 69626));
    }

    @Test
    void testFindTop3Elves(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        ElfCaloriesDetector detector = new ElfCaloriesDetector();
        Assertions.assertThat(detector.calculateSumOfTop3Elves(inputLines)).isEqualTo(206780);
    }
}