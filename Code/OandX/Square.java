import java.util.*;

public class Square {

  private int id;
  private String colour;
  private String type;
  private int score;
  private String ox;

  public Square(int inputId) {
    this.id = inputId;
    this.colour = setColour(); // "B" = black (corners), "W" = white
    this.type = setType(); // ME middle edge, CO corner, CE centre
    this.score = 0; // 1 for O (player); 10 for X (app)
    this.ox = " ";
  }

  private String setColour() {
    String colour;
    if (this.id % 2 == 1) {
      colour = "W";
    } else {
      colour = "B";
    }
    return colour;
  }

  private String setType() {
    String type = "CO";
    if (this.id % 2 == 1) {
      type = "ME";
    } else if (this.id == 4) {
      type = "CE";
    }
    return type;
  }

  public int getID() {
    return this.id;
  }
  public String getColour() {
    return this.colour;
  }
  public String getType() {
    return this.type;
  }
  public int getScore() {
    return this.score;
  }
  public String getOX() {
    return this.ox;
  }
  public void setScore(int inputScore) {
    this.score = inputScore;
  }
  public void setOX(String player) {
    if (player.equals("app")) {
      this.ox = "X";
    } else {
      this.ox = "O";
    }
  }
}



