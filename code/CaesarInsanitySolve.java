/**
 * reductio_ad_absurdum(flag)
 * to find the flag isn't as hard as you think it should
 * 
 * Everything here is reversed:
 * this means original is the encrypted password in the original source code
 * while encrypted is the original decrypted
 */

public class CaesarInsanitySolve { 
  static final String original = "pd9i_g5l7_du7_b5t9b_5eno4_z4_y8q8_ty4w7vp";
  static final int len = original.toCharArray().length;
  static void solve(String s) {
    char[] arr = s.toCharArray();
    for(int i = 0; i < len; i++) {
      arr[i] = shift(arr[i], 623);
      for(int j = len - 1; j >= 0; j--) {
        arr[j] = shift(arr[j], 184);
        for(int k = i; k < len; k++) {
          arr[k] = shift(arr[k], 567);
        }
      }
    }
    for(char c : arr) {
      System.out.print(c);
    }
  }
  
  /**
   * @param c the char
   * @param shift the shift
   * @return the shift reversed (in the opposite direction)
   */
  static char shift(char c, int shift) {
    if (c == '_')
      return c;
    if (c > 96) {
      shift /= 26;
      if (c + shift > 122) {
        c -= 26;
      }
      c -= shift;
    } else if (c < 96) {
      shift /= 9;
      if (c + shift > 57) {
        c -= 9;
      }
      c -= shift;
    }
    return c;
  }
  public static void main(String[] args) {
    solve("pd9i_g5l7_du7_b5t9b_5eno4_z4_y8q8_ty4w7vp");
  }
}
