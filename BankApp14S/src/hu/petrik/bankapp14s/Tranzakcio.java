
package hu.petrik.bankapp14s;

public class Tranzakcio {
    private Szamla kuldo;
    private Szamla fogado;
    private long osszeg;

    public Tranzakcio(Szamla kuldo, Szamla fogado, long osszeg) {
        
             if( (kuldo == fogado))
        {
             throw new IllegalArgumentException("A cél és a forrás nem eggyezhet meg ");
        }
        else if(osszeg < 0)
        {
              throw new IllegalArgumentException("Osszeg nem lehet negativ");
        }
        else
        {
        this.kuldo = kuldo;
        this.fogado = fogado;
        this.osszeg = osszeg;
        }
      
    }

    public Szamla getKuldo() {
        return kuldo;
    }

    public Szamla getFogado() {
        return fogado;
    }

    public long getOsszeg() {
        return osszeg;
    }
    
    
}
