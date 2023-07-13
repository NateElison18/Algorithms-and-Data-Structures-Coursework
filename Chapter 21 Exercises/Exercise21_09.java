/**
* Author: Nate Elison
* Date: 7/12/23
* This program saves the state capital array used in previous exercises in a hashmap
* and prompts users to enter a state and prints out that state's capital
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise21_09 {
	public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
	    
	    String[][] stateCapital = {
	    	      {"Alabama", "Montgomery"},
	    	      {"Alaska", "Juneau"},
	    	      {"Arizona", "Phoenix"},
	    	      {"Arkansas", "Little Rock"},
	    	      {"California", "Sacramento"},
	    	      {"Colorado", "Denver"},
	    	      {"Connecticut", "Hartford"},
	    	      {"Delaware", "Dover"},
	    	      {"Florida", "Tallahassee"},
	    	      {"Georgia", "Atlanta"},
	    	      {"Hawaii", "Honolulu"},
	    	      {"Idaho", "Boise"},
	    	      {"Illinois", "Springfield"},
	    	      {"Indiana", "Indianapolis"},
	    	      {"Iowa", "Des Moines"},
	    	      {"Kansas", "Topeka"},
	    	      {"Kentucky", "Frankfort"},
	    	      {"Louisiana", "Baton Rouge"},
	    	      {"Maine", "Augusta"},
	    	      {"Maryland", "Annapolis"},
	    	      {"Massachusettes", "Boston"},
	    	      {"Michigan", "Lansing"},
	    	      {"Minnesota", "Saint Paul"},
	    	      {"Mississippi", "Jackson"},
	    	      {"Missouri", "Jefferson City"},
	    	      {"Montana", "Helena"},
	    	      {"Nebraska", "Lincoln"},
	    	      {"Nevada", "Carson City"},
	    	      {"New Hampshire", "Concord"},
	    	      {"New Jersey", "Trenton"},
	    	      {"New York", "Albany"},
	    	      {"New Mexico", "Santa Fe"},
	    	      {"North Carolina", "Raleigh"},
	    	      {"North Dakota", "Bismarck"},
	    	      {"Ohio", "Columbus"},
	    	      {"Oklahoma", "Oklahoma City"},
	    	      {"Oregon", "Salem"},
	    	      {"Pennsylvania", "Harrisburg"},
	    	      {"Rhode Island", "Providence"},
	    	      {"South Carolina", "Columbia"},
	    	      {"South Dakota", "Pierre"},
	    	      {"Tennessee", "Nashville"},
	    	      {"Texas", "Austin"},
	    	      {"Utah", "Salt Lake City"},
	    	      {"Vermont", "Montpelier"},
	    	      {"Virginia", "Richmond"},
	    	      {"Washington", "Olympia"},
	    	      {"West Virginia", "Charleston"},
	    	      {"Wisconsin", "Madison"},
	    	      {"Wyoming", "Cheyenne"}
	    	    };
	    for (int i = 0; i < stateCapital.length; i++) 
	    	map.put(stateCapital[i][0], stateCapital[i][1]);
	   
		    Scanner input = new Scanner(System.in);
			String state = "Chicken";
			while (state.equalsIgnoreCase("exit") == false) {
				System.out.print("Enter state (enter 'exit' to end program): ");
				state = input.nextLine();
				System.out.println();
				if (state.equalsIgnoreCase("exit")) {
					System.out.println("Exiting program.");
				}
				else 
					System.out.println("The capital of " + state + " is " + map.get(state));
			}
	  }
}
