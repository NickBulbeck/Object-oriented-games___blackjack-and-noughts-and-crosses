// package blackjack;

import java.util.ArrayList;

// import static me.nick.blackjack.Rank.*;

/**
 * Created by user on 28/05/2017.
 */

public class Scorer {

    public Scorer() {

    }

    public static int getScore(Hand hand) {
        int score = 0;
        int aceCount = 0;
        ArrayList<Card> cards = hand.showCards();
        for (Card card : cards ) {
            int cardScore = scoreCard(card);
            if (card.getRank() == Rank.ACE) {
                aceCount += 1;
            }
            score += cardScore;
        }
        if ( (score > 21) && (aceCount > 0) ) {
            score = optimiseAces(score,aceCount);
        }
        if (score > 21) {
            score = -1;
//  This uses the (vague) Java precedent for returning -1 for non-existent values - which
//  a bust effectively is. The practical upshot is that any score returned by the
//  Scorer class that is greater than zero is a viable score; we won't have to test
//  whether it's <= 21.
        }
        return score;
    }

    private static int optimiseAces(int score, int aceCount) {
        for (int i = 0;i < aceCount; i++) {
            score -= 10;
            if (score < 22) {
                return score;
            }
        }
        return score;
    }

    private static int scoreCard(Card card) {
        int cardScore = 10;
        switch (card.getRank()) {
            case TWO:
                cardScore = 2;
                break;
            case THREE:
                cardScore = 3;
                break;
            case FOUR:
                cardScore = 4;
                break;
            case FIVE:
                cardScore = 5;
                break;
            case SIX:
                cardScore = 6;
                break;
            case SEVEN:
                cardScore = 7;
                break;
            case EIGHT:
                cardScore = 8;
                break;
            case NINE:
                cardScore = 9;
                break;
            case ACE:
                cardScore = 11;
        }
        return cardScore;
    }


}
