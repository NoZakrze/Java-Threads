package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ZbieraczWynikow
{
    private Queue<String> kolejka;

    public ZbieraczWynikow ()
    {
        this.kolejka = new LinkedList<>();
    }
    public synchronized void DodajWynik(int liczba, boolean wynik)
    {
        String odp;
        if(wynik)
            odp = new String(String.valueOf(liczba) + " jest pierwsza");
        else
            odp = new String(String.valueOf(liczba) + " nie jest pierwsza");
        kolejka.add(odp);
    }
    public void WypiszWyniki ()
    {
        for (String napis : kolejka)
        {
            System.out.println(napis);
        }
    }


}
