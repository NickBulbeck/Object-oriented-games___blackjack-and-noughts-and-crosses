import org.junit.*;
import static org.junit.Assert.*;

public class SquareTest {
  Square square1;
  Square square2;
  Square square3;

  @Before
  public void setup() {
    square1 = new Square(0); // corner
    square2 = new Square(1); // middle of an edge
    square3 = new Square(4); // centre
  }

  @Test
  public void canGetSquareId() {
    assertEquals(0,square1.getID());
  }
  @Test
  public void canGetSquareColour() {
    assertEquals("W",square2.getColour());
    assertEquals("B",square3.getColour());
    assertEquals("B",square1.getColour());
  }
  @Test
  public void canGetSquareType() {
    assertEquals("CO",square1.getType());
    assertEquals("ME",square2.getType());
    assertEquals("CE",square3.getType());
  }
  @Test public void canGetSquareScore() {
    assertEquals(0,square1.getScore());
  }
  @Test public void canSetSquareScore() {
    assertEquals(0,square1.getScore());
    square1.setScore(4);
    assertEquals(4,square1.getScore());
  }
  @Test
  public void canGetOX() {
    assertEquals(" ",square1.getOX());
  }
  @Test
  public void canSetOX() {
    square1.setOX("app");
    assertEquals("X",square1.getOX());
  }
}

