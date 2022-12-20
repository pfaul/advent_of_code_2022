package seyerlein.second;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class RockPaperScissorsTest
{
    private static List<String> INPUT_LINES;

    @BeforeAll
    public static void init() throws IOException, URISyntaxException
    {
        URI uri = RockPaperScissorsTest.class.getResource("/second/input.txt").toURI();
        Path path = Path.of(uri);
        INPUT_LINES = Files.readAllLines(path);
    }

    @Test
    void test(){
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Assertions.assertThat(rockPaperScissors.calculateResult(INPUT_LINES)).isEqualTo(123); //5990 = summe von X,Y,Z werten
    }
}