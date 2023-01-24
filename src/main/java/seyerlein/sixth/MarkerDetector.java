package seyerlein.sixth;

import java.util.HashSet;
import java.util.Set;

public class MarkerDetector
{
    public int getFirstMarker(String input)
    {
        char[] chars = input.toCharArray();
        if (chars.length < 4)
        {
            return -1;
        }
        for (int i = 3; i < chars.length; i++)
        {
            Set<Character> set = new HashSet<>();
            set.add(chars[i - 3]);
            set.add(chars[i - 2]);
            set.add(chars[i - 1]);
            set.add(chars[i]);
            if (set.size() == 4)
            {
                return i + 1;
            }
        }
        return -1;
    }
}
