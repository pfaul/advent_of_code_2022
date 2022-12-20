package seyerlein.first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElfCaloriesDetector
{
    public Elf findElfWithMostCalories(List<String> inputLines){
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
        return elves.stream()
                .max(Comparator.comparingInt(Elf::calories))
                .orElseThrow(()->new RuntimeException("Unable to find the elf"));
    }
}
