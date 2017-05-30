// package blackjack;

// import java.util.ArrayList;
// import java.util.Scanner;
import java.util.*;

/**
 * Created by user on 29/05/2017.
 */

public class Game {
    private Deck deck;
    private ArrayList<CardHolder> players;
    private Scanner sc;
    private Dealer dealer;
    private Player player;
    private int playerWins;
    private int dealerWins;


    public Game() {
        this.deck = new Deck();
        this.players = new ArrayList<CardHolder>();
        this.sc = new Scanner(System.in);
        setUpPlayers();
        this.dealer = (Dealer) this.players.get(0);
        this.player = (Player) this.players.get(1);
        this.playerWins = 0;
        this.dealerWins = 0;
    }


    public void play() {
        if (!testForBlackjack()) {
            stickOrTwist();
        }
        boolean stillHooked = true;
        do {
            System.out.println("You have " + playerWins + " wins; Dealer has " + dealerWins);
            System.out.println("Play again? (y/n)");
            String input = sc.next().toLowerCase();
            int deckSize = this.deck.countRemainingCards();
            if (deckSize < 10) {
                System.out.println("Sorry - only " + deckSize + " cards left. Hometime!");
                stillHooked = false;
            } else if (input.equals("y")) {
                setUpNextRound();
                testForBlackjack();
                stickOrTwist();
            } else if (input.equals("n")) {
                stillHooked = false;
            }
        } while (stillHooked);
        return;
    }

    private void setUpNextRound() {
        player.clearHand();
        dealer.clearHand();
        player.takeCard(this.deck);
        player.takeCard(this.deck);
        dealer.takeCard(this.deck);
        dealer.takeCard(this.deck);
    }

    private boolean testForBlackjack() {
        boolean blackjack = false;
        if (playerHasBlackjack()) {
            System.out.println("*** YOU HAVE BLACKJACK !! ***");
            closeGame();
            blackjack = true;
        }
        return blackjack;
    }


    private boolean playerHasBlackjack() {
        boolean blackjack = false;
        if (player.showScore() == 21) {
            blackjack = true;
        }
        return blackjack;
    }

    private void closeGame() {
        System.out.println(revealBothHands());
        System.out.println(compareFinalScores());
    }

    private String revealBothHands() {
        String dealerHand = ("Dealer's hand: " + dealer.showHand() + "\n");
        String playerHand = ("Your hand: " + player.showHand() + "\n");
        String table = dealerHand + playerHand;
        return table;
    }

    private void setUpPlayers() {
        Hand hand1 = deck.dealHand(2);
        Dealer dealer = new Dealer(hand1);
        Hand hand2 = deck.dealHand(2);
        Player player = new Player(hand2);
        players.add(dealer);
        players.add(player);
    }

    private String compareFinalScores() {
// Although there are numerous LOC in this method, they all serve the simple purpose
// of compiling a single string.
        int dScore = dealer.showScore();
        int pScore = player.showScore();
        String dealerScore;
        String playerScore;
        if (dScore < 1) {
            dealerScore = "Bust";
        } else {
            dealerScore = String.valueOf(dScore);
        }
        if (pScore < 1) {
            playerScore = "Bust";
        } else {
            playerScore = String.valueOf(pScore);
        }
        String result = "the game is drawn.";
        if (dScore > pScore) {
            result = "Dealer wins!";
            dealerWins += 1;
        } else if (pScore > dScore) {
            result = "You win!";
            playerWins += 1;
        }
        String scoreCompare = "Dealer's score: " + dealerScore + "; your score: "
                        + playerScore + "; " + result;
        return scoreCompare;
    }

    private void stickOrTwist() {
        boolean twisting = true;
        do {
            System.out.println("Your hand is: " + player.showHand());
            System.out.println("Twist? (y/n)");
            String input = sc.next().toLowerCase();
            if (input.equals("y")) {
                player.takeCard(this.deck);
                dealer.playTurn(this.deck);
                if (player.showScore() < 0) {
                    System.out.println("*** BAD LUCK - YOU'VE BUST !! ***");
                    closeGame();
                    return;
                }
            } else if (input.equals("n")) {
                twisting = false;
            }   
        } while (twisting);
        closeGame();
        return;
    }

//    getters used for testing the game
    public int getDeckSize() {
        return deck.countRemainingCards();
    }
    public int getPlayerNumbers() {
        return players.size();
    }

}
