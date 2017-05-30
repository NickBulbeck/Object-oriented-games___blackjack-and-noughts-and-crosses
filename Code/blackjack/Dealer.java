// package blackjack;

/**
 * Created by user on 29/05/2017.
 */

public class Dealer implements CardHolder {
    private Hand hand;

    public  Dealer(Hand inputHand) {
        this.hand = inputHand;
    }

    @Override
    public String showHand() {
        return this.hand.toString();
    }

    @Override
    public int showScore() {
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


    public void playTurn(Deck deck) {
        int dealerScore = showScore();
        if (dealerScore < 0) {
            return;
        }
        if ( dealerScore < 17 ) {
            Card card = deck.dealCard();
            this.hand.addCard(card);
        }
    }
}
