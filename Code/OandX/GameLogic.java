import java.util.*;

public class GameLogic {
  private ArrayList<Square> squareArray;
  private Integer[][] lines;

  public GameLogic() {
    this.squareArray = new ArrayList<Square>();
    this.lines = new Integer[8][4];
    setUpSquareArray();
    setUpLinesArrays();
  }

  private void setUpSquareArray() {
    for (int i=0; i<9; i++) {
      Square square = new Square(i);
      squareArray.add(square);
    }
  }
  private void setUpLinesArrays() {
    Integer interimArray[][] = {
      {0,1,2,(getSquareScore(0)+getSquareScore(1)+getSquareScore(2))}, // Top row
      {3,4,5,(getSquareScore(3)+getSquareScore(4)+getSquareScore(5))}, // Middle row
      {6,7,8,(getSquareScore(6)+getSquareScore(7)+getSquareScore(8))}, // Bottom row
      {0,3,6,(getSquareScore(0)+getSquareScore(3)+getSquareScore(6))}, // LH column
      {1,4,7,(getSquareScore(1)+getSquareScore(4)+getSquareScore(7))}, // Middle column
      {2,5,8,(getSquareScore(2)+getSquareScore(5)+getSquareScore(8))}, // RH column
      {0,4,8,(getSquareScore(0)+getSquareScore(4)+getSquareScore(8))}, // TL-BR diagonal
      {2,4,6,(getSquareScore(2)+getSquareScore(4)+getSquareScore(6))}  // TR-BL diagonal
    };
    this.lines = interimArray;
  }

  public int getSquareScore(int searchSquare) {
    int score = squareArray.get(searchSquare).getScore();
    return score;
  }
  public void setSquareScore(int searchSquare, int inputScore) {
    squareArray.get(searchSquare).setScore(inputScore);
    setUpLinesArrays();
  }
  public int getRowScore(int searchRow) {
    setUpLinesArrays();
    int rowScore = lines[searchRow][3];
    return rowScore;
  }
  public String getOX(int searchSquare) {
    String ox = squareArray.get(searchSquare).getOX();
    return ox;
  }
  public void setOX(int searchSquare,String ox) {
    squareArray.get(searchSquare).setOX(ox);
    if (ox.equals("app")) {
      setSquareScore(searchSquare,10);
    } else {
      setSquareScore(searchSquare,1);
    }
  }

  public ArrayList<Integer> getFreeSquares() {
    ArrayList<Integer> freeSquares = new ArrayList<Integer>();
    for (Square square : squareArray) {
      if (square.getScore() == 0) {
        freeSquares.add(square.getID());
      }
    }
    Collections.shuffle(freeSquares);
    return freeSquares;
  }

  public boolean freeSquare(int searchSquare) {
    if (getSquareScore(searchSquare) == 0) {
      return true;
    }
    return false;
  }

  public boolean winDetected() {
    for (int i = 0; i < 8; i++) {
      if ( (lines[i][3] == 3) || (lines[i][3] == 30) ) {
        return true;
      }
    }
    return false;
  }
// These next two functions need refactoring. I tried to do this on the train on 
// Thursday morning and broke it... so I'm leaving well alone!
  public int detectImminentWin() { 
    int line = detectImminentWinLine();
    if (line < 0) {
        return -1;
      }
    
    for (int i = 0; i < 3 ; i++) {
      if ( getSquareScore(lines[line][i]) == 0) {
        return lines[line][i];
      }
    }
    return -1; // This line should never be reached, but I need it to make the code compile!
  }

  public int detectImminentLoss() {
    int line = detectImminentLossLine();
    if (line < 0) {
      return -1;
    }
    for (int i = 0; i < 3 ; i++) {
      if ( getSquareScore(lines[line][i]) == 0) {
        return lines[line][i];
      }
    }
    return -1; // This line should never be reached, but I need it to make the code compile!
  }

  private int detectImminentWinLine() {
    for (int i = 0; i < 8; i++) {
      if ( (lines[i][3] == 20) ) { // imminent app win...
        return i;
      }
    }
    return -1;
  }

  private int detectImminentLossLine() {
    for (int i = 0; i < 8; i++) {
    if ( (lines[i][3] == 2) ) { // imminent app loss...
        return i;
      }
    }
    return -1;
  }

}









