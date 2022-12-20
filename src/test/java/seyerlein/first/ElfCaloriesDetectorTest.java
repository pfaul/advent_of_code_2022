package seyerlein.first;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class ElfCaloriesDetectorTest
{
    @Test
    void test() throws URISyntaxException, IOException
    {
        URI uri = ElfCaloriesDetectorTest.class.getResource("/first/input.txt").toURI();
        Path path = Path.of(uri);
        List<String> inputLines = Files.readAllLines(path);
        ElfCaloriesDetector detector = new ElfCaloriesDetector();
        Assertions.assertThat(detector.findElfWithMostCalories(inputLines)).isEqualTo(new Elf(229,69626));
    }
}