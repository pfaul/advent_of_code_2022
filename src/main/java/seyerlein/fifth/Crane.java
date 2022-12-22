package seyerlein.fifth;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;

public class Crane
{
    private final Pattern stepsPattern = Pattern.compile("move (\\d+) from (\\d) to (\\d)");

    //NOTE: staples index starting from 0, but processing steps start from index 1
    private final Map<Integer, LinkedList<Character>> staples = new HashMap<>();

    public void initialize(List<String> initialState)
    {
        initialState.forEach((String line) -> {
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++)
            {
                char aChar = chars[i];
                if (aChar == '-')
                {
                    continue;
                }
                Queue<Character> stack = staples.computeIfAbsent(i, key -> new LinkedList<>());
                stack.add(aChar);
            }
        });
    }

    public void processSteps(List<String> steps)
    {
        steps.stream()
                .map(stepsPattern::matcher)
                .filter(Matcher::find)
                .forEach(matcher -> {
                    int amount = Integer.parseInt(matcher.group(1));
                    int fromListId = Integer.parseInt(matcher.group(2)) - 1; //directly correct the index here (-1)
                    int toListId = Integer.parseInt(matcher.group(3)) - 1; //directly correct the index here (-1)
                    LinkedList<Character> fromList = staples.get(fromListId);
                    LinkedList<Character> toList = staples.get(toListId);

                    LinkedList<Character> crates = new LinkedList<>();
                    for (int i = 0; i < amount; i++)
                    {
                        Character firstChar = fromList.removeFirst();
                        crates.addLast(firstChar);
                    }
                    toList.addAll(0, crates);
                });
    }

    public String getResult()
    {
        return staples.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<Integer, LinkedList<Character>>::getKey))
                .map(Map.Entry::getValue)
                .map(LinkedList::removeFirst)
                .collect(Collector.of(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }
}
