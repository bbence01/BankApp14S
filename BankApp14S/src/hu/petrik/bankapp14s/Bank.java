
package hu.petrik.bankapp14s;

import java.util.ArrayList;
import java.util.List;





public class Bank {
    private List<Szamla> szamlak = new ArrayList<>();
    private List<Tranzakcio> tranzakciok = new ArrayList<>();
    
   private final String elotag;

    public Bank(String elotag) {
        this.elotag = elotag;
    }

    public String getElotag() {
        return elotag;
    }
    

    
    
    public void utalas(String honnan, String hova, long osszeg) {
        Szamla forras = null, cel = null;
        for (Szamla sz: szamlak) {
            if (honnan.equals(sz.getSzamlaszam())) {
                forras = sz;
            }
            else if (hova.equals(sz.getSzamlaszam())) {
                cel = sz;
            }
        }
        
        if( (cel == forras))
        {
             throw new NullPointerException("A cél és a forrás nem eggyezhet meg ");
             
        }
        else if(osszeg < 0)
        {
              throw new IllegalArgumentException("Osszeg nem lehet negativ");
        }
        else 
        {
        forras.setOsszeg(forras.getOsszeg() - osszeg);
        cel.setOsszeg(cel.getOsszeg() + osszeg);
        tranzakciok.add(new Tranzakcio(forras, cel, osszeg));
        }
    }

    /**
     *
     * @param sz
     */
    public void ujSzamla(Szamla sz) {
        
        
        
        if( !(sz.startsWith(elotag)) )
        {
            throw new IllegalArgumentException("Nem megfelelő Bankkód");
        }
        
        
        szamlak.add(sz);
        
    }
    
    
    //újra elvégzi a tranzakciót, de megcseréli a fogadód és a küldöd 
    
    public void tranzakcioVisszavonas(Tranzakcio t) {
        
        
                Szamla forras = null, cel = null;
        for (Szamla sz: szamlak) {
            if (t.getFogado().equals(sz.getSzamlaszam())) {
                forras = sz;
            }
            else if (t.getKuldo().equals(sz.getSzamlaszam())) {
                cel = sz;
            }
        }
        
        if( (cel == forras))
        {
             throw new NullPointerException("A cél és a forrás nem eggyezhet meg ");
             
        }
        else if(t.getOsszeg()< 0)
        {
              throw new IllegalArgumentException("Osszeg nem lehet negativ");
        }
        else 
        {
        forras.setOsszeg(forras.getOsszeg() - t.getOsszeg());
        cel.setOsszeg(cel.getOsszeg() + t.getOsszeg());
        tranzakciok.add(new Tranzakcio(forras, cel, t.getOsszeg()));
        }
        
        
       
    }

    List<Tranzakcio> getTranzakciok() {
        return new ArrayList<>(tranzakciok);
    }
}
