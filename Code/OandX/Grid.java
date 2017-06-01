import java.util.*;

public class Grid {
  private String[] squareArray;
  private Scanner sc;
  private GameLogic game;

  public Grid() {
    this.sc = new Scanner(System.in);
    this.game = new GameLogic();
  }

  public void playGame() {
    printGrid();
    int turns = 0;
    do {
      int chosenSquare = getUserInput();
      if ( chosenSquare < 0 ) {
        System.out.println("Not a valid input");
        continue;
      }
      addMove(chosenSquare,"Player");
      printGrid();
      if (winDetected()) {
        System.out.println("You've won - on yersel, mate!");
        return;
      }
      turns++;
      if (turns == 9) {
        System.out.println("Draw...");
        return;
      }
      doRandomComputerMove();
      printGrid();
      turns++;
      if (winDetected()) {
        System.out.println("The computer wins!");
        return;
      }
    } while (turns < 10);
    System.out.println("End of game...");
    return;
  }

  private void addMove(int square, String combatant) {
    game.setOX(square,combatant);
  }

  private void doRandomComputerMove() {
    int hotSquare = game.detectImminentWin(); // top priority
    if (hotSquare > 0) {
      addMove(hotSquare,"app");
      return; // may have imminent win AND imminent loss
    }
    hotSquare = game.detectImminentLoss(); 
    if (hotSquare > 0) {
      addMove(hotSquare,"app");
      return;
    }
    ArrayList<Integer> freeSquares = game.getFreeSquares();
    int square = freeSquares.get(0);
    addMove(square,"app");
  }


  private void printGrid() {
    String line1 = "       N       N       ";
    String line2 = "NNNNNNNNNNNNNNNNNNNNNNN";
    String contentLine1 = "   " + game.getOX(0)+ "   N   " + game.getOX(1) + "   N   " + game.getOX(2);
    String contentLine2 = "   " + game.getOX(3)+ "   N   " + game.getOX(4) + "   N   " + game.getOX(5);
    String contentLine3 = "   " + game.getOX(6)+ "   N   " + game.getOX(7) + "   N   " + game.getOX(8);
    String block1 = line1 + "\n" + contentLine1 + "\n" + line1 + "\n" + line2 + "\n";
    String block2 = line1 + "\n" + contentLine2 + "\n" + line1 + "\n" + line2 + "\n";
    String block3 = line1 + "\n" + contentLine3 + "\n" + line1 + "\n";
    String grid = block1 + block2 + block3;
    System.out.println(grid);
  }


  private int getUserInput() {
    System.out.println("Choose a square (enter a digit from 1 to 9)");
    String input = sc.next();
    if (!validInput(input)) {
      return -1;
    }
    int chosenSquare = Integer.parseInt(input) -1 ;
    if (!freeSquare(chosenSquare)) {
      return -1;
    }
    return chosenSquare;
  }

  private boolean validInput(String s) {
// I know this is clunky, but it's getting late
    if (s.equals("0") ||
        s.equals("1") ||
        s.equals("2") ||
        s.equals("3") ||
        s.equals("4") ||
        s.equals("5") ||
        s.equals("6") ||
        s.equals("7") ||
        s.equals("8") ||
        s.equals("9") ) {
      return true;
    }
    return false;
  }

  private boolean freeSquare(int chosenSquare) {
    if (game.freeSquare(chosenSquare)) {
      return true;
    }
    return false;
  }

  private boolean winDetected() {
    if (game.winDetected()) {
      return true;
    }
    return false;
  }

}











