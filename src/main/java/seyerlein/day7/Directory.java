package seyerlein.day7;

import java.util.Optional;

public class Directory
{
    private final Directory parent;
    private int size = 0;

    public Directory(Directory parent)
    {
        this.parent = parent;
    }

    public Optional<Directory> getParent()
    {
        return Optional.ofNullable(parent);
    }

    public int getSize()
    {
        return size;
    }

    public void incrementSize(int amount)
    {
        this.size += amount;
    }
}
