package seyerlein.first;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class ElfCaloriesDetectorTest
{
    private static List<String> INPUT_LINES;

    @BeforeAll
    public static void init() throws IOException, URISyntaxException
    {
        URI uri = ElfCaloriesDetectorTest.class.getResource("/first/input.txt").toURI();
        Path path = Path.of(uri);
        INPUT_LINES = Files.readAllLines(path);
    }

    @Test
    void testFindElf()
    {
        ElfCaloriesDetector detector = new ElfCaloriesDetector();
        Assertions.assertThat(detector.findElfWithMostCalories(INPUT_LINES)).isEqualTo(new Elf(229,69626));
    }

    @Test
    void testFindTop3Elves(){
        ElfCaloriesDetector detector = new ElfCaloriesDetector();
        Assertions.assertThat(detector.calculateSumOfTop3Elves(INPUT_LINES)).isEqualTo(206780);
    }
}