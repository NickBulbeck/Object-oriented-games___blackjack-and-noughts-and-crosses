// package blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 29/05/2017.
 */
public class GameTest {
    Game game;

    @Before

    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void canSetUpPlayers() {
        int players = game.getPlayerNumbers();
        assertEquals(2,players);
    }
    @Test
    public void openingDealsWork() {
        int cardsLeft = game.getDeckSize();
        assertEquals(48,cardsLeft);
    }
    
}

