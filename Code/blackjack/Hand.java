// package blackjack;

import java.util.ArrayList;

/**
 * Created by user on 27/05/2017.
 */

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    @Override
    public String toString() {
        String interimString = "";
        for (Card card : this.hand) {
            String cardString = card.toString() + ",";
            interimString += cardString;
        }
        String handToString = interimString.substring(0, interimString.length() - 1);
        return handToString;
    }

    public int handSize() {
        int handSize = this.hand.size();
        return handSize;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public ArrayList<Card> showCards() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards = this.hand;
        return cards;
    }
    public void empty() {
        this.hand.clear();
    }
}
