import java.util.Scanner;
import java.util.ArrayList;

public class Exercise22_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String string = "";
		String exit = "exit";
		
		while (string.equalsIgnoreCase(exit) == false) {
			System.out.print("Enter string: ");
			string = input.next();
			System.out.println("Maximum consecutive substring is " + getLongestSubString(string));
		}
	}
	
	public static String getLongestSubString(String string) {
		String longestSub = "";
		String subString = "";
		int startIndex = 0;
		int endIndex = 1;
		boolean found = false;
		
		for (int i = 0; i < string.length() - 1; i++) {
			if ((string.charAt(i + 1) - string.charAt(i)) == 1) {
				endIndex = (i + 2);
				if (endIndex > string.length() - 1) {
					endIndex = string.length();
				}
				subString = string.substring(startIndex, endIndex);
			}
			else {
				if (found) {
					subString = string.substring(startIndex, endIndex);
					startIndex = i + 1;
				}
				else {
					return "no substring found";
				}	
			}
			if (subString.length() > longestSub.length()) {
				longestSub = subString;
			}
		}
		return longestSub;
	}

}
