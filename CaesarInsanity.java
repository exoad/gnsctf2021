import java.util.Scanner;

public class CaesarInsanity {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the super secret password:");
		String password = scan.nextLine();
		scan.close();
		if (check(password)) {
			System.out.println("Correct password!");
			System.out.println("Make sure to submit the flag as gnsCTF{" + password + "}");
		} else {
			System.out.println("Incorrect password!");
		}
	}
	static boolean check(String password) {
		char[] arr = password.toCharArray();
		int len = arr.length;
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
		for (int i = 0; i < len; i++) {
			if (arr[i] != encrypted.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	static char shift(char c, int shift) {
		if (c == '_') return c;
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