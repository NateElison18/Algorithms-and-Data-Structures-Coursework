import java.util.*;

public class Exercise21_07 {
    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                }
                else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }
        ArrayList<WordOccurrence> wordOccurrences = new ArrayList<WordOccurrence>();

        map.forEach((k, v) ->{
            wordOccurrences.add(new WordOccurrence(k, v));
        });
        Collections.sort();

//        map.clear();
        for (int i = 0; i < wordOccurrences.size(); i++) {
//            map.put(wordOccurrences.get(i).getWord(), wordOccurrences.get(i).getCount());
            //System.out.println(wordOccurrences.get(i).getWord() + "\t" + );
        }

        // Display key and value for each entry
        map.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}