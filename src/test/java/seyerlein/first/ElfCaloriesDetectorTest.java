package seyerlein.first;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElfCaloriesDetectorTest
{
    @Test
    void test() throws URISyntaxException, IOException
    {
        URI uri = ElfCaloriesDetectorTest.class.getResource("/first/input.txt").toURI();
        Path path = Path.of(uri);
        List<String> inputLines = Files.readAllLines(path);
        System.out.println(inputLines);
    }
}