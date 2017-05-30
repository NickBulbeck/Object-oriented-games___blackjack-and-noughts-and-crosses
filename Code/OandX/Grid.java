import java.util.*;

public class Grid {
  private String[] squareArray;
  private Scanner sc;

  public Grid() {
    this.squareArray = new String[9];
    setUpBlankGrid();
    this.sc = new Scanner(System.in);
  }

  public void playGame() {
    printGrid();
    int turns = 0;
    do {
      System.out.println("Choose a square from 1 to 9:");
      String input = sc.next();
      int chosenSquare = Integer.parseInt(input) - 1;
      addMove(chosenSquare,"Player");
      printGrid();
      turns++;
      if (turns == 9) {
        System.out.println("End of game...");
        return;
      }
      doRandomComputerMove();
      printGrid();
      turns++;
    } while (turns < 10);
    System.out.println("End of game...");
    return;
  }

  private void addMove(int square, String combatant) {
    int index = square;
    if (combatant.equals("App")) {
      squareArray[index] = "   O   ";
    } else {
      squareArray[index] = "   X   ";
    }
  }

  private void doRandomComputerMove() {
    ArrayList<Integer> freeSquares = new ArrayList<Integer>();
    for (int i=0; i<9; i++) {
      if (squareArray[i].equals("       ")) {
        freeSquares.add(i);
      }
    }
    Collections.shuffle(freeSquares);
    int square = freeSquares.get(0);
    addMove(square,"App");
  }

  private void printGrid() {
    String line1 = "       X       X       ";
    String line2 = "XXXXXXXXXXXXXXXXXXXXXXX";
    String contentLine1 = squareArray[0] + "X" + squareArray[1] + "X" + squareArray[2];
    String contentLine2 = squareArray[3] + "X" + squareArray[4] + "X" + squareArray[5];
    String contentLine3 = squareArray[6] + "X" + squareArray[7] + "X" + squareArray[8];
    String block1 = line1 + "\n" + contentLine1 + "\n" + line1 + "\n" + line2 + "\n";
    String block2 = line1 + "\n" + contentLine2 + "\n" + line1 + "\n" + line2 + "\n";
    String block3 = line1 + "\n" + contentLine3 + "\n" + line1 + "\n";
    String grid = block1 + block2 + block3;
    System.out.println(grid);
  }

  private void setUpBlankGrid() {
    for (int i=0; i<9; i++) {
      squareArray[i] = "       ";
    }
  }




}











