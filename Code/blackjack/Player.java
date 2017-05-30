// package blackjack;

/**
 * Created by user on 29/05/2017.
 */

public class Player implements CardHolder {
    private Hand hand;

    public Player(Hand inputHand) {
        this.hand = inputHand;
    }
    public Player() {

    }

    @Override
    public String showHand() {
        return this.hand.toString();
    }

    @Override
    public int showScore() {
        if ( null == this.hand) {
            return 0;
        }
        int score = Scorer.getScore(this.hand);
        return score;
    }

    @Override
    public void takeCard(Deck deck) {
        Card card = deck.dealCard();
        this.hand.addCard(card);
    }

    public void clearHand() {
        this.hand.empty();
    }
}




