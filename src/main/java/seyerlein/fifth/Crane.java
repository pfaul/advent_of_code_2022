package seyerlein.fifth;

import java.util.*;
import java.util.stream.Collector;

public class Crane
{
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
//TODO
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
