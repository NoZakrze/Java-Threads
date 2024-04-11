package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ZbieraczZadan
{
    private Queue<Integer> kolejka;

    public ZbieraczZadan()
    {
        this.kolejka = new LinkedList<>();
    }
    public synchronized int PobierzZadanie() throws InterruptedException
    {
        while (kolejka.isEmpty())
            wait();
        return kolejka.poll();
    }
    public synchronized void ZglosZadanie(int liczba)
    {
        kolejka.add(liczba);
        notify();
    }

}
