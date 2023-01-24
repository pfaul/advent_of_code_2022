package seyerlein.day4;

import java.util.List;

public class AssignmentOptimizer
{
    public int findContainedRanges(List<String> inputLines)
    {
        return inputLines.stream()
                .map((String line) -> {
                    String[] split = line.split(",");
                    String[] firstGroup = split[0].split("-");
                    String[] secondGroup = split[1].split("-");
                    int firstStart = Integer.parseInt(firstGroup[0]);
                    int firstEnd = Integer.parseInt(firstGroup[1]);
                    int secondStart = Integer.parseInt(secondGroup[0]);
                    int secondEnd = Integer.parseInt(secondGroup[1]);
                    if (isFirstContainedInSecond(firstStart, firstEnd, secondStart, secondEnd) ||
                            isSecondContainedInFirst(firstStart, firstEnd, secondStart, secondEnd))
                    {
                        return 1;
                    }
                    return 0;
                })
                .reduce(0, Integer::sum);
    }

    private boolean isFirstContainedInSecond(int firstStart, int firstEnd, int secondStart, int secondEnd)
    {
        return firstStart >= secondStart && firstEnd <= secondEnd;
    }

    private boolean isSecondContainedInFirst(int firstStart, int firstEnd, int secondStart, int secondEnd)
    {
        return secondStart >= firstStart && secondEnd <= firstEnd;
    }

    public int findOverlappingRanges(List<String> inputLines)
    {
        return inputLines.stream()
                .map((String line) -> {
                    String[] split = line.split(",");
                    String[] firstGroup = split[0].split("-");
                    String[] secondGroup = split[1].split("-");
                    int firstStart = Integer.parseInt(firstGroup[0]);
                    int firstEnd = Integer.parseInt(firstGroup[1]);
                    int secondStart = Integer.parseInt(secondGroup[0]);
                    int secondEnd = Integer.parseInt(secondGroup[1]);
                    if (isFirstOverlappingSecond(firstStart, firstEnd, secondStart, secondEnd) ||
                            isSecondOverlappingFirst(firstStart, firstEnd, secondStart, secondEnd))
                    {
                        return 1;
                    }
                    return 0;
                })
                .reduce(0, Integer::sum);
    }

    private boolean isFirstOverlappingSecond(int firstStart, int firstEnd, int secondStart, int secondEnd)
    {
        return (firstStart >= secondStart && firstStart <= secondEnd)
                || (firstEnd >= secondStart && firstEnd <= secondEnd);
    }

    private boolean isSecondOverlappingFirst(int firstStart, int firstEnd, int secondStart, int secondEnd)
    {
        return (secondStart >= firstStart && secondStart <= firstEnd)
                || (secondEnd >= firstStart && secondEnd <= firstEnd);
    }
}
