import java.util.Arrays; 

class Solution {
    // Trie root = new Trie();
    String words[];
    int values[];
    int letters[] = new int[26];
    int maxValue = 0;
    
    static void p(Object o) {  System.out.println(o); }
    public static void main(String args[]) {
        String words1[] = {"dog","cat","dad","good"};
        char letters1[] = {'a','a','c','d','d','d','g','o','o'};
        int score1[] = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        String words2[] = {"xxxz","ax","bx","cx"};
        char letters2[] = {'z','a','b','c','x','x','x'};
        int score2[] = {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};

        p(new Solution().maxScoreWords(words2, letters2, score2));
    }

    int getWordValue(String word, int score[]) {
        int value = 0;
        for (int i = 0; i < word.length(); i++)
            value += score[word.charAt(i) - 'a'];
        return value;
    }
    
    void populateValues(int score[]) {
        this.values = new int[this.words.length];
        for (int i = 0; i < this.words.length; i++)
            this.values[i] = getWordValue(this.words[i], score);
    }

    int addWord(String word) {
        int i;

        for (i = 0; i < word.length(); i++)
            if (this.letters[word.charAt(i) - 'a'] == 0)
                break;
            else
                this.letters[word.charAt(i) - 'a']--;
        return (i - 1);
    }

    void removeWord(String word, int end) {
        for (int i = 0; i <= end; i++)
            this.letters[word.charAt(i) - 'a']++;
    }

    void allCombinations(int j, int value) {
        this.maxValue = Math.max(this.maxValue, value);
        for (int i = j; i < this.words.length; i++) {
            int end = addWord(this.words[i]);
            if (end == this.words[i].length() - 1) {
                allCombinations(i + 1, value + this.values[i]);
            }
            removeWord(this.words[i], end);
        }
    }
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        populateValues(score);
        for (char c : letters)
            this.letters[c - 'a']++;
        allCombinations(0, 0);
        return maxValue;
    }
}
