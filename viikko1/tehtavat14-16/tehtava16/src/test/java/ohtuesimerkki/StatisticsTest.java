package ohtuesimerkki;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {
            public List<Player> getPlayers() {
                ArrayList<Player> players = new ArrayList<>();
                players.add(new Player("Semenko", "EDM", 4, 12));
                players.add(new Player("Lemieux", "PIT", 45, 54));
                players.add(new Player("Kurri",   "EDM", 37, 53));
                players.add(new Player("Yzerman", "DET", 42, 56));
                players.add(new Player("Gretzky", "EDM", 35, 89));
                return players;
            }
        };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void etsiiJaLoytaaPelaajaaNimenPerusteella() {
        Player pelaaja = stats.search("Kurri");

        assertEquals(pelaaja.getName(), "Kurri");
    }

    @Test
    public void etsiiEiLoydaPelaajaaNimenPerusteella() {
        Player pelaaja = stats.search("Koivu");

        assertEquals(pelaaja, null);
    }

    @Test
    public void etsiiKaikkiJoukkuenPelaajat() {
        List<Player> pelaajat = stats.team("EDM");

        assertEquals(pelaajat.size(), 3);
    }

    @Test
    public void etsiiParhaatMaalinTekijat() {
        List<Player> pelaajat = stats.topScorers(0);

        assertEquals(pelaajat.size(), 1);
        assertEquals(pelaajat.get(0).getName(), "Gretzky");
    }
}
