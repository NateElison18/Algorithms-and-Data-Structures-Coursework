/**
 * Author: Nate Elison
 * Date: 7/13/23
 *
 * This program takes in 2 strings and checks to see if string 2 is a substring of string 1, if so, it prints at what index the substring is found.
 */

import java.util.Scanner;

public class Exercise22_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = "";
        String s2 = "";
        String exit = "exit";

        while (s2.equalsIgnoreCase(exit) == false && s1.equalsIgnoreCase(exit) == false) {
            System.out.print("Enter a string s1: ");
            s1 = input.nextLine();
            System.out.print("Enter a string s2: ");
            s2 = input.nextLine();

            findSubString(s1, s2);
            System.out.println("\nEnter " + exit + " for any string to end the program.\n");
        }
    }

    public static void findSubString(String s1, String s2) {
        if (s1.length() < s2.length()) {
            System.out.println("String 1 must be longer than string 2. Please retry");
            return;
        }
        String subStringS1 = s1.substring(0, s2.length());
        for (int i = 0; i < (s1.length() - s2.length() + 1); i++) {
            if (subStringS1.equalsIgnoreCase(s2)) {
                System.out.println("Matched at index " + i);
                return;
            }
            else {
                try {
                    subStringS1 = s1.substring((i + 1), (s2.length() + i + 1));
                }
                catch (StringIndexOutOfBoundsException e){
                    System.out.println("No match found");
                    return;
                }
            }
        }
        System.out.println("No match found");
    }
}
