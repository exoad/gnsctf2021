import java.util.*;
public class DaultVoor2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the password to our highly secure Dault Voor!");
    String pw = in.nextLine();
    if (check(pw)) {
      System.out.println("Correct! Encase the password in gnsCTF{} and submit!");
    }
    else {
      System.out.println("Wrong! SOUND THE ALARMS, AN INTRUDER HAS BEEN FOUND");
    }
  }

  public static boolean check(String password) {
    String enc = "";
    for (char c : password.toCharArray()) {
      if (c == '_') {
        enc += c;
      }
      
      else if (c > 47 && c < 58) { //between 0 and 9
        enc += (char)(c*2); //move c count by mult 2
      }

      else if (c > 96 && c < 122) { //between a annd y
        enc += (char)(c-35); //move c ount down 35
      }
    }
	System.out.println("1" + enc);
//113 117 49 99 107 _ 109 178 102 102 141
//qu1ck_m4RR5
    return enc.equals("NRb@H_JhCCj");
  }
}