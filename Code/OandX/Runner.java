public class Runner {

  public static void main(String[] args) {
    String line1 = "         X       X       ";
    String line2 = "  XXXXXXXXXXXXXXXXXXXXXXX";
    String block1 = line1 + "\n" + line1 + "\n" + line1;
    String grid = block1 + "\n" + line2 + "\n" + block1 + "\n" + line2 + "\n" + block1;
    System.out.println(grid);

  }

}
