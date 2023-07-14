/**
 * Author: Nate Elison
 * Date: 6/13/23
 *
 * This program takes in a string and prints a substring of the maximum consecutive increasingly ordered characters found in that string.
 */

import java.util.Scanner;

public class Exercise22_01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = "";
        String exit = "exit";

        while (string.equalsIgnoreCase(exit) == false) {
            System.out.print("Enter string (enter exit to quit program): ");
            string = input.next();
            System.out.println("Maximum consecutive substring is " + getLongestSubString(string));
        }
    }

    public static String getLongestSubString(String string) {
        String longestSub = "";
        String subString;
        int startIndex = 0;
        int endIndex = 1;

        for (int i = 0; i < string.length() - 1; i++) {
            if ((string.charAt(i + 1) - string.charAt(i)) == 1) {
                endIndex = (i + 2);
                if (endIndex > string.length() - 1)
                    endIndex = string.length();
                subString = string.substring(startIndex, endIndex);
            }
            else {
                subString = string.substring(startIndex, endIndex);
                startIndex = i + 1;
                endIndex++;
            }
            if (subString.length() > longestSub.length())
                longestSub = subString;

        }
        if (longestSub.length() == 1)
            return "no consecutive characters found";
        else
            return longestSub;
    }

}
