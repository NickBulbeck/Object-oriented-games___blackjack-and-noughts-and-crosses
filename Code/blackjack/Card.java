// package blackjack;

/**
 * Created by user on 27/05/2017.
 */

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank inputRank, Suit inputSuit) {
        this.rank = inputRank;
        this.suit = inputSuit;
    }
    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        String output = this.rank.toString() + " OF " + this.suit.toString();
        return output;
    }
}
