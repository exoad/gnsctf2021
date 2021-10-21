import java.util.Scanner;
public class CaesarInsanity {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the super secret password:");
		while (true) {
			String password = scan.nextLine();
			scan.close();
			if (check(password)) {
				System.out.println("Correct password!");
				break;
			} else
				System.out.println("Incorrect password!");
		}
	}
	/**
	 * @param password the password to compare with the variable encrypted
	 * @return if true the password is correct else false 
	 */
	static boolean check(String password) {
		char[] arr = password.toCharArray();
		int len = arr.length;
		//encryption method
		// the part to actually reverse
		for (int i = 0; i < len; i++) {
			arr[i] = shift(arr[i], 623);
			for (int j = len - 1; j >= 0; j--) {
				arr[j] = shift(arr[j], 184);
				for (int k = i; k < len; k++) {
					arr[k] = shift(arr[k], 567);
			}	
			}
		}
		String encrypted = "pd9i_g5l7_du7_b5t9b_5eno4_z4_y8q8_ty4w7vp";
		//comparing the encrypted password against the original password
		for (int i = 0; i < len; i++)
			if (arr[i] != encrypted.charAt(i))
				return false;
		return true;
	}
	/**
	 * @param c this is the char the method will shift
	 * @param shift the amount of shift
	 * @return the character shifted (throughout the ascii table with the char added by an int of shift)
	 * 
	 * Process:
	 * CONDITION #1: if the char is turned in as the underscore space key, it will be ignored 
	 * Condition #2 PART A: if the char is bigger than char pos 96 (a to ~) =>
	 * {
	 * 		alter shift by mod 26
	 * 		CONDITION #2 PART B: if the char (int) plus the shift value is between { and ~ => {
	 * 	  	move c down (-) 26 shifts
	 * 	  }
	 *    move c up shift value
	 * } 
	 * CONDITION #3 PART A: if the char is smaller than pos 96 (_ to [SPACE]) => {
	 *    alter the shift by mod 9
	 *    CONDITION #3 PART B: if the char (int) plus the shift value is between _ & ~ => {
	 *     move c down (-) 9 shifts
	 *    }
	 * 	  move c up shift value
	 * }
	 */
	static char shift(char c, int shift) {
		if (c == '_')
			return c;
		if (c > 96) {
			shift %= 26;
			if (c + shift > 122) {
				c -= 26;
			}
			c += shift;
		} else if (c < 96) {
			shift %= 9;
			if (c + shift > 57) {
				c -= 9;
			}
			c += shift;
		}
		return c;
	}
}