// package blackjack;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 27/05/2017.
 */
public class DeckTest {
    Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
    }

    @Test
    public void deckHas52Cards() {
        assertEquals(52,deck.countRemainingCards());
    }

    @Test
    public void canDealCard() {
        Deck deck2 = new Deck();
        Card dealtCard = deck2.dealCard();
        assertEquals(51,deck2.countRemainingCards());
//  The following is not a formal test; but at least should show 
//  that the deck has some randomness to it!
        System.out.println("dealtCard: " + dealtCard.toString());
    }

    @Test
    public void canDealTwoCards() {
        Deck deck2 = new Deck();
        Card firstCard = deck2.dealCard();
        System.out.println("First card: " + firstCard.toString());

        Card secondCard = deck2.dealCard();
        System.out.println("Second card:" + secondCard.toString());

        assertEquals(50,deck2.countRemainingCards());
    }
    @Test
    public void canCreateHand() {
        Hand hand = deck.dealHand(2);
        int handSize = hand.handSize();
        int deckSize = deck.countRemainingCards();
        assertEquals(2,handSize);
        assertEquals(50,deckSize);
    }
    @Test public void handLooksRealistic() {
        Hand hand = deck.dealHand(2);
//  Again, this test is not designed to pass, but to display the hand and
//  inspect (though not, strictly, test) it for randomness.
        System.out.println("Dealt hand: " + hand.toString());
    }
}