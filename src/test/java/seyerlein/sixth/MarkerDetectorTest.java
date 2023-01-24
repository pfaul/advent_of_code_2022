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
        String input = inputLines.get(0);
        MarkerDetector detector = new MarkerDetector();
        Assertions.assertThat(detector.getFirstPaketMarker(input)).isEqualTo(1531);
        Assertions.assertThat(detector.getFirstMessageMarker(input)).isEqualTo(2518);
    }

    @ParameterizedTest
    @CsvSource(value = {"mjqjpqmgbljsphdztnvjfqwrcgsmlb,7,19",
            "bvwbjplbgvbhsrlpgdmjqwftvncz,5,23",
            "nppdvjthqldpwncqszvftbrmjlhg,6,23",
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg,10,29",
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw,11,26",
            "abc,-1,-1",
            "abcd,4,-1"})
    void testSamples(String input, int expectedResultPaket, int expectedResultMessage)
    {
        MarkerDetector detector = new MarkerDetector();
        Assertions.assertThat(detector.getFirstPaketMarker(input)).isEqualTo(expectedResultPaket);
        Assertions.assertThat(detector.getFirstMessageMarker(input)).isEqualTo(expectedResultMessage);
    }
}