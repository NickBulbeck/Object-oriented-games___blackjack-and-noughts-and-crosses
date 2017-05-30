// package blackjack;

//import org.junit.Before;
//import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;
//
/**
 * Created by user on 27/05/2017.
 */
public class CardTest {
    Card card;
    @Before
    public void setUp() throws Exception {
        card = new Card(Rank.TWO, Suit.HEARTS);
    }

    @Test
    public void canGetCardName() {
        assertEquals(Suit.HEARTS,card.getSuit());
    }
    @Test
    public void canGetCardRank() {
        assertEquals(Rank.TWO,card.getRank());
    }
}