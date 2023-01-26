package seyerlein.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSystemCalculator
{
    private static final int THRESHOLD = 100000;
    private static final int REQUIRED_DISK_SPACE = 16592386;
    private static final Pattern FILE_SIZE_PATTERN = Pattern.compile("(\\d+)\s");

    public int getSumOfDirectories(List<String> inputLines)
    {
        //parse commands into datastructure
        List<Directory> dirs = this.parseInput(inputLines);
        //find all dirs with specific file size
        //sum all dirs
        return dirs.stream()
                .map(Directory::getSize)
                .filter(size -> size <= THRESHOLD)
                .reduce(0, Integer::sum);
    }

    public int getDirectorySizeToBeDeleted(List<String> inputLines)
    {
        //parse commands into datastructure
        List<Directory> dirs = this.parseInput(inputLines);
        //find all dirs with specific file size
        //sum all dirs
        return dirs.stream()
                .map(Directory::getSize)
                .filter(size -> size >= REQUIRED_DISK_SPACE)
                .min(Integer::compare)
                .orElse(-1);
    }

    private List<Directory> parseInput(List<String> inputLines)
    {
        List<Directory> result = new ArrayList<>();
        Directory currentDir = null;
        for (String line : inputLines)
        {
            Matcher matcher = FILE_SIZE_PATTERN.matcher(line);

            if (line.startsWith("$ cd ..") && currentDir != null)
            {
                result.add(currentDir);
                currentDir = currentDir.getParent().orElse(null);
            }
            else if (line.startsWith("$ cd"))
            {
                Directory dir = new Directory(currentDir);
                //save root directory to result
                if (currentDir == null)
                {
                    result.add(dir);
                }
                //change pointer
                currentDir = dir;
            }
            else if (matcher.find())
            {
                //file size line
                int fileSize = Integer.parseInt(matcher.group(1));
                Directory directoryPointer = currentDir;
                while (directoryPointer != null)
                {
                    directoryPointer.incrementSize(fileSize);
                    directoryPointer = directoryPointer.getParent().orElse(null);
                }
            }
            //ignore ls and dir lines completely
        }
        //must add the last directory to the result as well
        result.add(currentDir);
        return result;
    }
}
