package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ZbieraczZadan zbieracz = new ZbieraczZadan();
        ZbieraczWynikow wyniki = new ZbieraczWynikow();
        ArrayList<Watek> Watki = new ArrayList<>();
        int ilosc = Integer.parseInt(args[0]);
        for(int i=0;i<ilosc;i++)
        {
            Watek w = new Watek(zbieracz,wyniki);
            Watki.add(w);
            w.start();
        }
        String input;
        while(true)
        {
            input = scanner.next();
            if(input.equals("end"))
            {
               for(Watek w : Watki)
               {
                   w.setKoniec(true);
               }
                break;
            }
            else
            {
                int DanaLiczba = Integer.parseInt(input);
                zbieracz.ZglosZadanie(DanaLiczba);
            }
        }
        scanner.close();
        for(Watek w: Watki)
        {
            try
            {
                w.join();
            }
            catch (InterruptedException e)
            {}
        }
        wyniki.WypiszWyniki();


    }
}