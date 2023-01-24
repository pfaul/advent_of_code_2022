package seyerlein.sixth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seyerlein.ListStringResource;
import seyerlein.ListStringResourceExtension;

import java.util.List;

@ExtendWith(ListStringResourceExtension.class)
class MarkerDetectorTest
{
    private static final String INPUT_FILE = "/sixth/input.txt";

    @Test
    void test(@ListStringResource(INPUT_FILE) List<String> inputLines)
    {
        MarkerDetector detector = new MarkerDetector();
        Assertions.assertThat(detector.getFirstMarker(inputLines.get(0))).isEqualTo(123);
    }

    @ParameterizedTest
    @CsvSource(value = {"mjqjpqmgbljsphdztnvjfqwrcgsmlb,7",
            "bvwbjplbgvbhsrlpgdmjqwftvncz,5",
            "nppdvjthqldpwncqszvftbrmjlhg,6",
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg,10",
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw,11"})
    void testOverlappingRangesSample(String input, int expectedResult)
    {
        MarkerDetector detector = new MarkerDetector();
        Assertions.assertThat(detector.getFirstMarker(input)).isEqualTo(expectedResult);
    }
}