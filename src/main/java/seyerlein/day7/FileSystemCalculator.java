package seyerlein.day7;

import java.util.ArrayList;
import java.util.List;

public class FileSystemCalculator
{
    private static final int THRESHOLD = 100000;

    public int getSumOfDirectories(List<String> inputLines)
    {
        //parse commands into datastructure(?)
        List<Directory> dirs = this.parseInput(inputLines);
        //find all dirs with specific file size
        //sum all dirs
        return dirs.stream()
                .map(Directory::size)
                .filter(size -> size <= THRESHOLD)
                .reduce(0, Integer::sum);
    }

    private List<Directory> parseInput(List<String> inputLines)
    {
        List<Directory> dirs = new ArrayList<>();
        int depth = 0;
        for (String line : inputLines)
        {
            if (line.startsWith("$ cd"))
            {
                //change pointer
            }
            else if (line.startsWith("$ ls"))
            {
                //read until next $
            }
        }
        return dirs;
    }
}
