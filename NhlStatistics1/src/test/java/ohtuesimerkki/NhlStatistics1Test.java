package ohtuesimerkki;

import java.util.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class NhlStatistics1Test {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
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
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchReturnsTheCorrectPlayer() {
        Player player = stats.search("Kurri");
        assertEquals("Kurri", player.getName());
    }

    @Test
    public void searchReturnsNullWhenPlayerNotFound() {
        assertNull(stats.search("Momo"));
    }

    @Test
    public void teamReturnsCorrectAmountOfPlayers() {
        assertEquals(3, stats.team("EDM").size());
    }

    @Test
    public void teamReturnsEmptyListCorrectly() {
        assertTrue(stats.team("XXX").isEmpty());
    }

    @Test
    public void topScorersReturnsAskedAmountOfPlayers() {
        assertFalse(stats.topScorers(3).isEmpty());
    }
}
