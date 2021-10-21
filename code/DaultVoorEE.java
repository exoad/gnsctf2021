import java.util.*;

public class DaultVoorEE {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the password to our highly secure Dault Voor!");
    String pw = in.nextLine();
      if(!check(pw))
        puts("nope");
      else
        puts("yes");
        
  }

  public static boolean check(String password) {
    // My electric eye broke and messed up the bit arrangements... SAD!
    byte[] bytes = password.getBytes();
    int[] chunks = new int[password.length() / 4];
    for (int i = 0; i < chunks.length; i++) {
      chunks[i] = bytes[i * 4] << 24 | bytes[i * 4 + 1] << 16 | bytes[i * 4 + 2] << 8 | bytes[i * 4 + 3];
    }
    int[] rotChunks = new int[chunks.length];
    for (int i = 0; i < rotChunks.length; i++) {
      rotChunks[i] = rotateRight(chunks[i], i * 6);
    }
    return rotChunks[0] == 1832155490 && rotChunks[1] == -590512956 && rotChunks[2] == 859174627
        && rotChunks[3] == 1473976589 && rotChunks[4] == 892431156;
  }

  public static int rotateRight(int i, int rot) {
    return (i >>> rot) | (i << (32 - rot));
  }

  public static void puts(Object j) {
    System.out.println(j);
  }
}