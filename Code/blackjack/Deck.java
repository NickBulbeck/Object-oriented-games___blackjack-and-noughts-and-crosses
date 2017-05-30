// package blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 27/05/2017.
 */

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(cards);
    }

    public int countRemainingCards() {
        int cardsRemaining = cards.size();
        return cardsRemaining;
    }

    public Card dealCard() {
        Card dealtCard = cards.remove(0);
        return dealtCard;
    }

    public Hand dealHand(int handSize) {
        ArrayList<Card> newCards = new ArrayList<Card>();
        Hand newHand = new Hand();
        for (int i = 0; i < handSize; i++ ) {
            Card dealtCard = dealCard();
            newHand.addCard(dealtCard);
        }
        return newHand;
    }
}
