public class WordOccurrence implements Comparable<WordOccurrence>{
    String word;
    int count;

    WordOccurrence(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(WordOccurrence wordOccurrence) {
        if (getCount() > wordOccurrence.getCount())
            return 1;
        else if (getCount() < wordOccurrence.getCount())
            return -1;
        else
            return 0;
    }
}