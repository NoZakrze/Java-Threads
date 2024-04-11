package org.example;

public class Watek extends Thread
{
    private ZbieraczZadan zbieracz;
    private ZbieraczWynikow wyniki;
    private int dana;
    private boolean wynik;
    private boolean koniec;
    private boolean czyZadanie;

    public Watek(ZbieraczZadan zbieracz, ZbieraczWynikow wyniki)
    {

        this.zbieracz = zbieracz;
        this.koniec = false;
        this.czyZadanie = false;
        this.wyniki = wyniki;
    }
    public boolean CzyPierwsza(int a)
    {
        if(a== 1 || a==0)
        {
            return false;
        }
        boolean wynik = true;
        for(int i=2;i<a;i++)
        {
            if(a%i==0)
            {
                wynik = false;
                break;
            }
        }
        return wynik;
    }
    @Override
    public void run()
    {
       try
       {
            while (true)
            {
                dana = zbieracz.PobierzZadanie();
                czyZadanie = true;
                wynik = CzyPierwsza(dana);
                this.sleep(2000);
                PrzekazWynik(dana,wynik,this.wyniki);
                czyZadanie = false;
                if(this.koniec)
                {
                    this.interrupt();
                }
            }
       }
       catch (InterruptedException e)
       {

       }
    }

    public void PrzekazWynik(int liczba, boolean wynik,ZbieraczWynikow z)
    {
       z.DodajWynik(liczba,wynik);
    }

    public void setKoniec(boolean koniec)
    {
        this.koniec = koniec;
        if(!this.czyZadanie)
        {
            this.interrupt();
        }
    }
}
