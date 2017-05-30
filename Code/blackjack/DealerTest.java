// package blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 29/05/2017.
 */
public class DealerTest {
    Deck deck;
    Hand hand16;
    Hand hand17;
    Dealer dealer16;
    Dealer dealer17;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        hand16 = new Hand();
        hand17 = new Hand();
        card1 = new Card(Rank.KING,Suit.DIAMONDS);
        card2 = new Card(Rank.SIX,Suit.SPADES);
        card3 = new Card(Rank.SEVEN,Suit.SPADES);

        hand16.addCard(card1);
        hand16.addCard(card2);
        dealer16 = new Dealer(hand16);

        hand17.addCard(card1);
        hand17.addCard(card3);
        dealer17 = new Dealer(hand17);
    }

    @Test
    public void canReadDealerCards() {
        String handString = dealer16.showHand();
        assertEquals("KING OF DIAMONDS,SIX OF SPADES",handString);
    }

    @Test
    public void canGetDealerScore() {
        assertEquals(16,dealer16.showScore());
    }

    @Test
    public void dealer16TwistsOnPlayTurn() {
//  FOR REFERENCE: dealer must twist until score is >= 17, according to Wikipedia.
//  I have interpreted this to mean that the dealer will twist IF BOTH the player twists AND
//  the dealer's score is < 17.
        dealer16.playTurn(deck);
        assertFalse(dealer16.showScore() == 16);
    }

    @Test
    public void dealer17SticksOnPlayTurn() {
        dealer17.playTurn(deck);
        assertEquals(17,dealer17.showScore());
    }

    @Test
    public void canClearHand() {
        dealer17.clearHand();
        assertEquals(0,dealer17.showScore());
    }

}



