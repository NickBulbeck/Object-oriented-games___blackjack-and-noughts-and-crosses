// package blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 29/05/2017.
 */
public class PlayerTest {
    Deck deck;
    Hand hand16;
    Hand hand20;
    Player player;
    Player player16;
    Player player20;
    Card card1;
    Card card2;
    Card card3;
    Card card4;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        hand16 = new Hand();
        hand20 = new Hand();
        card1 = new Card(Rank.ACE,Suit.DIAMONDS);
        card2 = new Card(Rank.FIVE,Suit.SPADES);
        card3 = new Card(Rank.TEN,Suit.CLUBS);
        card4 = new Card(Rank.QUEEN,Suit.HEARTS);


        hand16.addCard(card1);
        hand16.addCard(card2);
        player16 = new Player(hand16);

        hand20.addCard(card3);
        hand20.addCard(card4);
        player20 = new Player(hand20);

        player = new Player();
    }

    @Test
    public void canReadPlayerHand() throws Exception {
        String handString = player16.showHand();
        assertEquals("ACE OF DIAMONDS,FIVE OF SPADES",handString);
    }

    @Test
    public void canGetPlayerScore() throws Exception {
        int score = player20.showScore();
        assertEquals(20,score);
    }
    @Test
    public void canGetPlayerScoreWithNoPresetHand() {
        assertEquals(0,player.showScore());
    }

    @Test
    public void player20UsuallyBustsOnTwist() throws Exception {
        player20.takeCard(deck);
        assertEquals(-1,player20.showScore());
//  This assumes, of course, that the test doesn't deal an Ace. The test will fail, on
//  average, one time in 13! Repeated running of the test did indeed produce a large
//  majority of passes with the occasional failure.
// The next one will always fail, but provides interesting information.
//        assertEquals("Test trigger",player20.showHand());
    }

    @Test
    public void canClearPlayerHand() {
        player20.clearHand();
        assertEquals(0,player20.showScore());
    }

}