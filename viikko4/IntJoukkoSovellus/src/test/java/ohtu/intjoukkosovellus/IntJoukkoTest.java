package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko(1,1);
    }

    @Test
    public void lisataanYksiNumero() {
        joukko.lisaa(4);
        assertEquals(1, joukko.mahtavuus());
    }

    @Test
    public void lisataanKaksiNumeroa() {
        joukko.lisaa(10);
        joukko.lisaa(3);
        assertEquals(2, joukko.mahtavuus());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        joukko.lisaa(10);
        joukko.lisaa(3);
        assertTrue(joukko.kuuluu(10));
        assertFalse(joukko.kuuluu(5));
        assertTrue(joukko.kuuluu(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.lisaa(10);
        joukko.lisaa(3);
        joukko.poista(3);
        assertFalse(joukko.kuuluu(3));
        assertEquals(1, joukko.mahtavuus());
    }
    
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaa(luku);
        }
        assertEquals(12, joukko.mahtavuus());
        assertTrue(joukko.kuuluu(11));
        joukko.poista(11);
        assertFalse(joukko.kuuluu(11));
        assertEquals(11, joukko.mahtavuus());
    }
    
    @Test
    public void toStringToimii(){
        joukko.lisaa(10);
        joukko.lisaa(3);
        assertEquals("{10, 3}", joukko.toString());
    }
    
    @Test
    public void toStringToimiiYhdenKokoiselleJoukolla(){
        joukko.lisaa(1);
        assertEquals("{1}", joukko.toString());
    }

    @Test
    public void toStringToimiiTyhjallaJoukolla(){
        assertEquals("{}", joukko.toString());
    }     
}
