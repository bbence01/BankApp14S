

package hu.petrik.bankapp14s;

import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SzamlaTest {
    
    public SzamlaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void kezdoErtekHelyes() {
        Szamla sz = new Szamla("12341234-56785678-00000000", 50000);
        
        assertEquals("Osszeg nem stimmel", 50000, sz.getOsszeg());
        assertEquals("Szamlaszam nem stimmel", "12341234-56785678-00000000", sz.getSzamlaszam());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void osszegNemLehetNegativ() {
        Szamla sz = new Szamla("12341234-56785678-00000000", -5000);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void szamlaszamFormatuma() {
        Szamla sz = new Szamla("1234-5678", 1000);
    }
    
     @Test(expected = AssertionFailedError.class)
    public void joelotag() {
        Szamla sz = new Szamla("45641234-56785678-00000000", 50000);
    }
   
}
