import org.junit.*;
import static org.junit.Assert.*;

public class GameLogicTest {
  GameLogic gameLogic;

  @Before
  public void setup() {
    gameLogic = new GameLogic();
  }

  @Test
  public void canGetSquareScore() {
    int score = gameLogic.getSquareScore(4);
    assertEquals(0,score);
  }
  @Test
  public void canSetSquareScore() {
    int score = gameLogic.getSquareScore(4);
    assertEquals(0,score);
    gameLogic.setSquareScore(4,10);
    score = gameLogic.getSquareScore(4);
    assertEquals(10,score);
  }
  @Test
  public void canDetectImminentWin() {
    gameLogic.setSquareScore(0,1);
    gameLogic.setSquareScore(2,1);
    int rowScore = gameLogic.getRowScore(0);
    assertEquals(2,rowScore);
  }

}