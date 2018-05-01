
package hu.petrik.bankapp14s;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {
    
    public BankTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void sikeresUtalas() {
        Bank bank = new Bank("123");
        Szamla sz1 = new Szamla("12340000-11111111-00000000", 100000);
        Szamla sz2 = new Szamla("12380000-11111111-00000000", 5000);
        bank.ujSzamla(sz1);
        bank.ujSzamla(sz2);
        bank.utalas("12340000-11111111-00000000", "12380000-11111111-00000000", 10000);
        
        assertEquals("Forras osszeg nem stimmel", 90000, sz1.getOsszeg());
        assertEquals("Cel osszeg nem stimmel", 15000, sz2.getOsszeg());
        assertEquals("Nem jott letre uj tranzakcio", 1, bank.getTranzakciok().size());
    }
    
    @Test (expected = NullPointerException.class)
    public void celforraas ()
    {
             Bank bank = new Bank("123");
        Szamla sz1 = new Szamla("12340000-11111111-00000000", 100000);
        Szamla sz2 = new Szamla("12380000-11111111-00000000", 5000);
        bank.ujSzamla(sz1);
        bank.ujSzamla(sz2);
        bank.utalas("12340000-11111111-00000000", "12340000-11111111-00000000", 10000);
        
    }
    
        @Test (expected = IllegalArgumentException.class)
    public void rosszosszeg ()
    {
             Bank bank = new Bank("123");
        Szamla sz1 = new Szamla("12340000-11111111-00000000", 100000);
        Szamla sz2 = new Szamla("12380000-11111111-00000000", 5000);
        bank.ujSzamla(sz1);
        bank.ujSzamla(sz2);
        bank.utalas("12340000-11111111-00000000", "12380000-11111111-00000000", -10000);
        
    }
    
    @Test
    public void viszza(){
        Bank bank = new Bank("123");
        Szamla sz1 = new Szamla("12340000-11111111-00000000", 100000);
        Szamla sz2 = new Szamla("12380000-11111111-00000000", 5000);
        bank.ujSzamla(sz1);
        bank.ujSzamla(sz2);
                      
        
        Tranzakcio tr = new Tranzakcio(sz2, sz2, 5000);
        
        long elott1 = sz1.getOsszeg();
        long elott2 = sz2.getOsszeg();
        
        
        bank.tranzakcioVisszavonas(tr);
        
         long utan1 = sz1.getOsszeg();
        long utan2 = sz2.getOsszeg();      
              
        assertEquals(elott1, utan1);
         assertEquals(elott2, utan2);
      
        
         
        
        
    }
}
