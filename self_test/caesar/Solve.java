import java.util.*;


public class Solve {
  public static void main(String[] args) {
    check("pd9i_g5l7_du7_b5t9b_5eno4_z4_y8q8_ty4w7vp");
  }
  
  static String solve(String s) {
    String original = s;
    char[] arr = original.toCharArray();
    int len = arr.length;

    return original;
  }

  static void check(String password) {
    char[] arr = password.toCharArray();
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i]);
      arr[i] = shift(arr[i], 623);
      for (int j = len - 1; j >= 0; j--) {
        arr[j] = shift(arr[j], 184);
        for (int k = i; k < len; k++) {
        
          arr[k] = shift(arr[k], 567);
        }
      }
    }
    System.out.println();
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i]);
    }
  }
  
  static char shift(char c, int shift) {
    if (c == '_')
      return c;
    if (c > 96) {
      shift -= 26;
      if (c + shift > 122) {
        c += 26;
      }
      c += shift;
    } else if (c < 96) {
      shift -= 9;
      if (c + shift > 57) {
        c += 9;
      }
      c += shift;
    }
    return c;
  }
}
