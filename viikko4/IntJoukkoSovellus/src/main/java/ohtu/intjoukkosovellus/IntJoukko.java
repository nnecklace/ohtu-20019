
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, 
                            OLETUSKASVATUS = 5;
    private int kapasiteetti;
    private int kasvatuskoko;
    private int[] lukuJono;
    private int alkioidenMaara;

    public IntJoukko() {
        this.kapasiteetti = OLETUSKAPASITEETTI;
        this.lukuJono = new int[this.kapasiteetti];
        this.alkioidenMaara = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            this.kapasiteetti = OLETUSKAPASITEETTI;
        } else {
            this.kapasiteetti = kapasiteetti;
        }
        this.lukuJono = new int[this.kapasiteetti];
        this.alkioidenMaara = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            this.kapasiteetti = OLETUSKAPASITEETTI;
        } else {
            this.kapasiteetti = kapasiteetti;
        }

        if (kasvatuskoko <= 0) {
            this.kasvatuskoko = OLETUSKASVATUS;
        } else {
            this.kasvatuskoko = kasvatuskoko;
        }
        this.lukuJono = new int[kapasiteetti];
        this.alkioidenMaara = 0;
    }

    public void lisaa(int luku) {
        if (alkioidenMaara == kapasiteetti) {
            int[] uusiLukuJono = new int[lukuJono.length + kasvatuskoko];
            for (int i = 0; i < lukuJono.length; i++) {
                uusiLukuJono[i] = lukuJono[i];
            }
            lukuJono = uusiLukuJono;
            kapasiteetti += kasvatuskoko;
        }
        lukuJono[alkioidenMaara++] = luku;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < lukuJono.length; i++) {
            if (luku == lukuJono[i]) {
                return true;
            }
        }

        return false;
    }

    public void poista(int luku) {
        int pituus = 0;
        for (int i = 0; i < lukuJono.length; i++) {
            if (lukuJono[i] == luku) continue;
            lukuJono[pituus++] = lukuJono[i];
        }
        lukuJono = Arrays.copyOf(lukuJono, pituus);
        alkioidenMaara = pituus;
    }

    public int mahtavuus() {
        return alkioidenMaara;
    }


    @Override
    public String toString() {
        if (alkioidenMaara == 0) {
            return "{}";
        } else if (alkioidenMaara == 1) {
            return "{" + lukuJono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenMaara - 1; i++) {
                tuotos += lukuJono[i];
                tuotos += ", ";
            }
            tuotos += lukuJono[alkioidenMaara - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] getLukuJono() {
        return lukuJono;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        int[] aLukuJono = a.getLukuJono();
        int[] bLukuJono = b.getLukuJono();
        IntJoukko x = new IntJoukko(1,1);
        for (int i = 0; i < aLukuJono.length; i++) {
            if (aLukuJono[i] > 0) x.lisaa(aLukuJono[i]);
        }
        for (int i = 0; i < bLukuJono.length; i++) {
            if (bLukuJono[i] > 0) x.lisaa(bLukuJono[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        int[] aLukuJono = a.getLukuJono();
        int[] bLukuJono = b.getLukuJono();
        IntJoukko x = new IntJoukko(1,1);

        for (int i = 0; i < aLukuJono.length; i++) {
            for (int j = 0; j < bLukuJono.length; j++) {
                if (aLukuJono[i] == bLukuJono[j] && aLukuJono[i] > 0) x.lisaa(aLukuJono[i]);
            }
        }

        return x;
    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        int[] aLukuJono = a.getLukuJono();
        int[] bLukuJono = b.getLukuJono();
        IntJoukko x = new IntJoukko(1,1);

        for (int i = 0; i < aLukuJono.length; i++) {
            x.lisaa(aLukuJono[i]);
        }
        for (int i = 0; i < bLukuJono.length; i++) {
            x.poista(bLukuJono[i]);
        }
 
        return x;
    }
        
}