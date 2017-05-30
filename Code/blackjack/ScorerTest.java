// package blackjack;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

// import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by user on 28/05/2017.
 */
public class ScorerTest {
    Scorer scorer = new Scorer();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void canScoreTwoCardsWithoutPictures() {
        Hand hand = new Hand();
        Card card1 = new Card(Rank.FIVE,Suit.CLUBS);
        Card card2 = new Card(Rank.TEN,Suit.SPADES);
        hand.addCard(card1);
        hand.addCard(card2);
        assertEquals(15,scorer.getScore(hand));
    }

    @Test
    public void canScoreTwoCardsWithPicture() {
        Hand hand = new Hand();
        Card card1 = new Card(Rank.JACK,Suit.CLUBS);
        Card card2 = new Card(Rank.TEN,Suit.SPADES);
        hand.addCard(card1);
        hand.addCard(card2);
        assertEquals(20,scorer.getScore(hand));
    }

    @Test
    public void canScoreTwoCardsWithTwoPictures() {
        Hand hand = new Hand();
        Card card1 = new Card(Rank.JACK,Suit.CLUBS);
        Card card2 = new Card(Rank.KING,Suit.SPADES);
        hand.addCard(card1);
        hand.addCard(card2);
        assertEquals(20,scorer.getScore(hand));
    }

    @Test
    public void canScoreOneAce() {
        Hand hand = new Hand();
        Card card1 = new Card(Rank.JACK,Suit.CLUBS);
        Card card2 = new Card(Rank.ACE,Suit.SPADES);
        hand.addCard(card1);
        hand.addCard(card2);
        assertEquals(21,scorer.getScore(hand));
    }

    @Test
    public void canScoreFiveCards() {
        Hand hand = new Hand();
        Card card1 = new Card(Rank.TWO,Suit.CLUBS);
        Card card2 = new Card(Rank.THREE,Suit.SPADES);
        Card card3 = new Card(Rank.TWO,Suit.SPADES);
        Card card4 = new Card(Rank.FIVE,Suit.HEARTS);
        Card card5 = new Card(Rank.EIGHT,Suit.DIAMONDS);
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);
        hand.addCard(card4);
        hand.addCard(card5);
        assertEquals(20,scorer.getScore(hand));
    }

    @Test
    public void canHandleMultipleAces() {
        Hand hand = new Hand();
        Card card1 = new Card(Rank.ACE,Suit.CLUBS);
        Card card2 = new Card(Rank.SEVEN,Suit.SPADES);
        Card card3 = new Card(Rank.ACE,Suit.SPADES);
        Card card4 = new Card(Rank.ACE,Suit.HEARTS);
        Card card5 = new Card(Rank.ACE,Suit.DIAMONDS);
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);
        hand.addCard(card4);
        hand.addCard(card5);
        assertEquals(21,scorer.getScore(hand));
    }

    @Test
    public void canHandleBustWithAces() {
        Hand hand = new Hand();
        Card card1 = new Card(Rank.ACE,Suit.CLUBS);
        Card card2 = new Card(Rank.EIGHT,Suit.SPADES);
        Card card3 = new Card(Rank.ACE,Suit.SPADES);
        Card card4 = new Card(Rank.ACE,Suit.HEARTS);
        Card card5 = new Card(Rank.ACE,Suit.DIAMONDS);
        Card card6 = new Card(Rank.TEN,Suit.HEARTS);
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);
        hand.addCard(card4);
        hand.addCard(card5);
        hand.addCard(card6);
        assertEquals(-1,scorer.getScore(hand));
    }

    @Test
    public void canHandleBustWithNoAces() {
        Hand hand = new Hand();
        Card card1 = new Card(Rank.THREE,Suit.CLUBS);
        Card card2 = new Card(Rank.SEVEN,Suit.SPADES);
        Card card3 = new Card(Rank.TWO,Suit.SPADES);
        Card card4 = new Card(Rank.SEVEN,Suit.HEARTS);
        Card card5 = new Card(Rank.JACK,Suit.DIAMONDS);
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);
        hand.addCard(card4);
        hand.addCard(card5);
        assertEquals(-1,scorer.getScore(hand));
    }

}