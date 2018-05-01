
package hu.petrik.bankapp14s;

import java.util.regex.Pattern;
import java.lang.String;

public class Szamla {
    private static final String SZAMLASZAM_MINTA = "^[0-9]{8}-[0-9]{8}-[0-9]{8}$";
    private String szamlaszam;
    private long osszeg;
    private Bank bank;

    public Szamla(String szamlaszam, long osszeg) {
        if (osszeg < 0) {
            throw new IllegalArgumentException("Osszeg nem lehet negativ");
        }
        if (!Pattern.matches(SZAMLASZAM_MINTA, szamlaszam)) {
            throw new IllegalArgumentException("Szamlaszam formatuma nem jo");
        }
    
        
        this.szamlaszam = szamlaszam;
        this.osszeg = osszeg;
    }

    public String getSzamlaszam() {
        return szamlaszam;
    }

    public long getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(long osszeg) {
        this.osszeg = osszeg;
    }

    boolean startsWith(String elotag) {
       
        
     if (szamlaszam.startsWith(elotag))
     {
         return true;
     }
     else
     {
         return  false;
     }
        
    }

    

 
   
    
}
