// package blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 27/05/2017.
 */
public class HandTest {
    Hand hand;
    Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        hand = deck.dealHand(2);

    }

    @Test
    public void canAddCardToHand() {
        Card card = new Card(Rank.ACE,Suit.SPADES);
        hand.addCard(card);
        assertEquals(3,hand.handSize());
    }


    @Test
    public void canGetHandString() {
        Card card1 = new Card(Rank.FIVE,Suit.DIAMONDS);
        Card card2 = new Card(Rank.KING,Suit.SPADES);
        Hand hand1 = new Hand();
        hand1.addCard(card1);
        hand1.addCard(card2);
        String testString = "FIVE OF DIAMONDS,KING OF SPADES";
        assertEquals(testString,hand1.toString());
    }

    @Test
    public void canEmptyHand() {
        hand.empty();
        assertEquals(0,hand.handSize());
    }

}