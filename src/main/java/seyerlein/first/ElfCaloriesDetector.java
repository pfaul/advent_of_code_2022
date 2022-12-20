package seyerlein.first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElfCaloriesDetector
{
    public Elf findElfWithMostCalories(List<String> inputLines){
        List<Elf> elves = parseInputToElves(inputLines);
        return elves.stream()
                .max(Comparator.comparingInt(Elf::calories))
                .orElseThrow(()->new RuntimeException("Unable to find the elf"));
    }

    public int calculateSumOfTop3Elves(List<String> inputLines){
        List<Elf> elves = this.parseInputToElves(inputLines);
        return elves.stream()
                .map(Elf::calories)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(0,Integer::sum);
    }

    private List<Elf> parseInputToElves(List<String> inputLines)
    {
        List<Elf> elves = new ArrayList<>();
        int elfPosition = 0;
        int caloriesSum = 0;
        for (String line : inputLines)
        {
            if (line.isEmpty())
            {
                elves.add(new Elf(elfPosition, caloriesSum));
                elfPosition += 1;
                caloriesSum = 0;
            }else{
                caloriesSum += Integer.parseInt(line);
            }
        }
        return elves;
    }
}
