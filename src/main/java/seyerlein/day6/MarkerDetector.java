package seyerlein.day6;

import java.util.HashSet;
import java.util.Set;

public class MarkerDetector
{
    public int getFirstPaketMarker(String input)
    {
        return this.getFirstMarker(input, 4);
    }

    public int getFirstMessageMarker(String input)
    {
        return this.getFirstMarker(input, 14);
    }

    public int getFirstMarker(String input, int position)
    {
        char[] chars = input.toCharArray();
        if (chars.length < position)
        {
            return -1;
        }
        for (int i = position - 1; i < chars.length; i++)
        {
            Set<Character> set = new HashSet<>();
            for (int iter = 0; iter < position; iter++)
            {
                set.add(chars[i - iter]);
            }
            if (set.size() == position)
            {
                return i + 1;
            }
        }
        return -1;
    }
}
